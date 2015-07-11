package Assesortron;

import Database.Database;
import Objects.DrawRequestDTO;
import Objects.DrawRequestItemDTO;
import Objects.FieldValueDTO;
import Objects.ProjectDTO;
import Objects.SiteWalkDTO;
import Objects.WalkThroughDTO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;


public class ExcelConverter {
    
    private static final int ITEM_TITLE_COLUMN = 1;
    private static final int ITEM_VALUE_COLUMN = 2;
    private static final int TYPE_ROW_BUFFER_HEIGHT = 2;
    private static final int STARTING_ROW = 2;
    
    int rowNumber;
    int columnNumber;
    Workbook wb;
    
    String nameProposal;
    
    private boolean TESTING = false;
    
    
    public void open(String nameProposal, boolean local) {
        this.TESTING = local;
        FileOutputStream fileOut = null;
        wb = new HSSFWorkbook();
        wb.createSheet(WorkbookUtil.createSafeSheetName(nameProposal));
        if (TESTING) {
            this.nameProposal = nameProposal;
        }
    }
    
    
    public void renderProject(ProjectDTO project) {
        for(SiteWalkDTO sw: project.getSiteWalks()) {
            renderSiteWalks(sw);
        }
    }
    
    public void renderSiteWalks(SiteWalkDTO siteWalk) {
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.createRow(STARTING_ROW);
        Cell startingCell = row.createCell(ITEM_TITLE_COLUMN);
        CreationHelper createHelper = wb.getCreationHelper();
        
        startingCell.setCellValue(createHelper.createRichTextString("Date"));
        startingCell = moveCellRight(startingCell, sheet, 1);
        startingCell.setCellValue(createHelper.createRichTextString(siteWalk.getStartDate().toString()));
        startingCell = moveCellDown(startingCell, sheet, 2);
        startingCell = moveCellRight(startingCell, sheet, -1);
        
        startingCell.setCellValue(createHelper.createRichTextString("Field Report"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = moveCellRight(startingCell, sheet, 1);
        
        startingCell = renderFieldValues(siteWalk.getInFieldValues(), startingCell);
        
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = moveCellRight(startingCell, sheet, -1);
        
        startingCell.setCellValue(createHelper.createRichTextString("Draw Request"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = startingCell.getRow().createCell(ITEM_VALUE_COLUMN);

        startingCell = render(siteWalk.getDrawRequest(), startingCell);

        startingCell = moveCellDown(startingCell, sheet, TYPE_ROW_BUFFER_HEIGHT);
        startingCell = startingCell.getRow().createCell(ITEM_TITLE_COLUMN);
        startingCell.setCellValue(createHelper.createRichTextString("Walk Throughs"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = startingCell.getRow().createCell(ITEM_VALUE_COLUMN);

        startingCell = renderWalkThroughs(siteWalk.getWalkThroughs(), startingCell);
    }
    
    public byte[] saveDocument() {
        if (!TESTING) {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                wb.write(baos);
                return baos.toByteArray();
            } catch (IOException ex) {
                Logger.getLogger(ExcelConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            File file = new File("test" + ".xls");
            FileOutputStream fileOut = null;
            try {
                fileOut = new FileOutputStream(file);
                wb.write(fileOut);    
                fileOut.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExcelConverter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ExcelConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        return null;
    }
    
//    private Cell render(ChangeOrderDTO[] changeOrders, Cell startingCell) {
//        Sheet sheet = wb.getSheetAt(0);
//        CreationHelper createHelper = wb.getCreationHelper();
//        
//        String[] headers = {
//            "Sub contractor",
//            "amount",
//            "description",
//            "executed?"
//        };
//        
//        
//        for (int i = 0; i < headers.length; i++) {
//            startingCell.setCellValue(createHelper.createRichTextString(headers[i]));
//            startingCell = moveCellRight(startingCell, sheet, 1);
//        }
//        startingCell = moveCellRight(startingCell, sheet, headers.length * -1);
//        startingCell = moveCellDown(startingCell, sheet, 1);
//        
//        for (int i = 0; i < changeOrders.length; i++) {
//            render(changeOrders[i], sheet, startingCell);
//            startingCell = moveCellDown(startingCell, sheet, 1);
//        }
//        
//        return moveCellDown(startingCell, sheet, changeOrders.length);
//    }
//    
//    private void render(ChangeOrderDTO changeOrder, Sheet sheet, Cell startingCell) {
//        CreationHelper createHelper = wb.getCreationHelper();
//        String executed;
//        if (changeOrder.isExecuted()) {
//            executed = "Yes";
//        } else {
//            executed = "no";
//        }
//        String[] values = {
//            changeOrder.getSubContractor(),
//            changeOrder.getAmount()+"",
//            changeOrder.getDescription(),
//            executed
//        };
//        
//        for (int i = 0; i < values.length; i++) {
//            startingCell.setCellValue(createHelper.createRichTextString(values[i]));
//            startingCell = moveCellRight(startingCell, sheet, 1);
//        }
//        startingCell = moveCellRight(startingCell, sheet, values.length * -1);
//    }
    
    private Cell render(DrawRequestDTO drawRequest, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        String[] rowTitles = {
            "Current Request",
            "Recommendation for Funding",
            "Conditions"
        };
        String[] rowValues = new String[rowTitles.length];
            if (drawRequest.getCurrentRequest()!= null)  
                rowValues[0] = drawRequest.getCurrentRequest().toString();
            if (drawRequest.getCurrentRecommendation()!= null)
                rowValues[1] = drawRequest.getCurrentRecommendation().toString();
            if (drawRequest.getConditions()!= null) 
                rowValues[2] = drawRequest.getConditions().toString();

        
        for (int i = 0; i < rowTitles.length; i++) {
            startingCell.setCellValue(createHelper.createRichTextString(rowTitles[i]));
            startingCell = moveCellRight(startingCell, sheet, 1);
            startingCell.setCellValue(createHelper.createRichTextString(rowValues[i]));
            startingCell = moveCellRight(moveCellDown(startingCell, sheet, 1), sheet, -1);
        }
        
        startingCell = this.moveCellDown(startingCell, sheet, 1);
        startingCell.setCellValue(createHelper.createRichTextString("Items"));
        startingCell = this.moveCellRight(startingCell, sheet, 1);
        startingCell = this.moveCellDown(startingCell, sheet, 1);

        startingCell = render(drawRequest.getDrawRequestItems(), startingCell);
        
        return startingCell;
        
    }
    
    private Cell render(List<DrawRequestItemDTO> drawRequestItems, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        String[] columnTitles = {
            "Type",
            "SubContractor",
            "Amount",
            "Executed?",
            "Description"
        };
        
        for (int i = 0; i < columnTitles.length; i++) {
            startingCell.setCellValue(createHelper.createRichTextString(columnTitles[i]));
            startingCell = moveCellRight(startingCell, sheet, 1);
        }
        startingCell = this.moveCellDown(startingCell, sheet, 1);
        startingCell = this.moveCellRight(startingCell, sheet, columnTitles.length * -1);
        for (DrawRequestItemDTO drI: drawRequestItems) {
            if (drI.getTypeName() != null) {
                startingCell.setCellValue(createHelper.createRichTextString(drI.getTypeName()));
            }
            startingCell = this.moveCellRight(startingCell, sheet, 1);
            if (drI.getSubContractor()!= null) {
                startingCell.setCellValue(createHelper.createRichTextString(drI.getSubContractor()));
            }
            startingCell = this.moveCellRight(startingCell, sheet, 1);
            startingCell.setCellValue(createHelper.createRichTextString(drI.getAmount() + ""));
            startingCell = this.moveCellRight(startingCell, sheet, 1);
            startingCell.setCellValue(createHelper.createRichTextString(drI.isExecuted() ? "yes" : "no"));
            startingCell = this.moveCellRight(startingCell, sheet, 1);
            if (drI.getDescription() != null) {
                startingCell.setCellValue(createHelper.createRichTextString(drI.getDescription()));
            }
            
            startingCell = this.moveCellDown(startingCell, sheet, 1);
            startingCell = this.moveCellRight(startingCell, sheet, (columnTitles.length - 1) * -1);
            }
        return startingCell;
        }
        

    private Cell renderFieldValues(List<FieldValueDTO> fieldValues, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        
        for (FieldValueDTO fv: fieldValues) {
            startingCell.setCellValue(createHelper.createRichTextString(fv.getField()));
            startingCell = this.moveCellRight(startingCell, sheet, 1);
            startingCell.setCellValue(createHelper.createRichTextString(fv.getValue()));
            startingCell = this.moveCellRight(startingCell, sheet, -1);
            startingCell = this.moveCellDown(startingCell, sheet, 1);
        }
        
        return startingCell;
    }
    
    
    private Cell renderWalkThroughs(List<WalkThroughDTO> walkThroughs, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        
        String[] headers = {
            "floor",
            "trade",
            "progress",
            "comments"
        };

        Row headerRow = sheet.createRow(startingCell.getRowIndex());
        Cell cell;
        for (int i = 0; i < headers.length; i++) {
            cell = headerRow.createCell(startingCell.getColumnIndex()+i);
            cell.setCellValue(createHelper.createRichTextString(headers[i]));
        }
        
        startingCell = moveCellDown(startingCell, sheet, 1);
        
        for (int i = 0; i < walkThroughs.size(); i++) {
            render(walkThroughs.get(i), sheet, startingCell);
            startingCell = moveCellDown(startingCell, sheet, 1);
        }
        
        return startingCell;
    }
    
    private void render(WalkThroughDTO walkThrough, Sheet sheet, Cell startingCell) {
        CreationHelper createHelper = wb.getCreationHelper();    
        
        String imageHeader = "images (" + walkThrough.getPictures().size()+")";
     
        String[] columnValues = {
            walkThrough.getFloor(),
            walkThrough.getTrade(),
            walkThrough.getProgress(),
            walkThrough.getNotes()
        };
        
        Row row = sheet.createRow(startingCell.getRowIndex());
        for(int i = 0; i < columnValues.length; i++) {
            Cell cell = row.createCell(startingCell.getColumnIndex() + i);
            cell.setCellValue(createHelper.createRichTextString(columnValues[i]));
            }
        
        for(int i = 0; i <  walkThrough.getPictures().size(); i ++) {
            Cell cell = row.createCell(columnValues.length + i);
            renderPicture(walkThrough.getPicture(i), sheet, cell);         
        }
    }      
    
    private void renderPicture(UUID picID, Sheet sheet, Cell cell) {
        CreationHelper createHelper = wb.getCreationHelper();
        
        InputStream is = null;
            int pictureIndex = 0;
            try {
                is = new FileInputStream(Database.retrievePicture(picID));
                byte[] bytes = IOUtils.toByteArray(is);
                pictureIndex = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
                is.close();
                Drawing drawing = sheet.createDrawingPatriarch();
                ClientAnchor anchor = createHelper.createClientAnchor();
            
                anchor.setCol1(cell.getColumnIndex());
                anchor.setRow1(cell.getRowIndex());
                Picture pic = drawing.createPicture(anchor, pictureIndex);
            } catch (FileNotFoundException ex) {
                //thrown by new FileInputStream
            } catch (IOException ex) {
                try {
                    is.close();
                    //thrown by IOUtils.toByteArray
                } catch (IOException ex1) {
                }
            }  
    }
    
    private Cell moveCellDown(Cell cell, Sheet sheet, int numberCellsDown) {
        Row row = sheet.createRow(cell.getRowIndex()+ numberCellsDown);
        return row.createCell(cell.getColumnIndex());
    }
    
    private Cell moveCellRight(Cell cell, Sheet sheet, int numberCellsRight) {
        Row row = sheet.getRow(cell.getRowIndex());
        int cellLocation = cell.getColumnIndex() + numberCellsRight;
        if (row.getCell(cellLocation) == null) {
            return row.createCell(cellLocation);
        } else {
            return row.getCell(cellLocation);
        }
    }

 
}
