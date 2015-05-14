package Assesortron;

/**
  * Add your first API methods in this class, or you may create another class. In that case, please
  * update your web.xml accordingly.
 **/
import Database.Database;
import Interfaces.Writer;
import Objects.ChangeOrderDTO;
import Objects.DrawRequestDTO;
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


public class ExcelConverter implements Writer {
    
    private static final int itemTitleColumn = 1;
    private static final int itemValueColumn = 2;
    private static final int typeRowBufferHeight = 2;
    private static final int startingRow = 2;
    
    private List<ChangeOrderDTO> changeOrders = new ArrayList<>();
    private List<WalkThroughDTO> walkThroughs = new ArrayList<>(); 
    private List<DrawRequestDTO> drawRequests = new ArrayList<>();
    
    int rowNumber;
    int columnNumber;
    Workbook wb;
    
    
    public void open(String nameProposal) {
        FileOutputStream fileOut = null;
        wb = new HSSFWorkbook();
        wb.createSheet(WorkbookUtil.createSafeSheetName(nameProposal));
    }

    @Override
    public void write(ChangeOrderDTO changeOrder) {
        changeOrders.add(changeOrder);
    }

    @Override
    public void write(DrawRequestDTO drawRequest) {
        drawRequests.add(drawRequest);
    }
    
    @Override
    public void write(ProjectDTO project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(SiteWalkDTO siteWalk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(WalkThroughDTO walkThrough) {
        walkThroughs.add(walkThrough);
    }
    
    public void renderDocument() {
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.createRow(startingRow);
        Cell startingCell = row.createCell(itemTitleColumn);
        CreationHelper createHelper = wb.getCreationHelper();
        
        startingCell.setCellValue(createHelper.createRichTextString("Draw Requests"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = startingCell.getRow().createCell(itemValueColumn);
        
        for(DrawRequestDTO drawRequest: drawRequests) {
            startingCell = render(drawRequest, startingCell);
        }
        
        startingCell = moveCellDown(startingCell, sheet, typeRowBufferHeight);
        startingCell = startingCell.getRow().createCell(itemTitleColumn);
        startingCell.setCellValue(createHelper.createRichTextString("Change Orders"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = startingCell.getRow().createCell(itemValueColumn);
        
        ChangeOrderDTO[] changeOrdersArray = new ChangeOrderDTO[changeOrders.size()];
        startingCell = render(changeOrders.toArray(changeOrdersArray), startingCell);
        
        startingCell = moveCellDown(startingCell, sheet, typeRowBufferHeight);
        startingCell = startingCell.getRow().createCell(itemTitleColumn);
        startingCell.setCellValue(createHelper.createRichTextString("Walk Throughs"));
        startingCell = moveCellDown(startingCell, sheet, 1);
        startingCell = startingCell.getRow().createCell(itemValueColumn);
        
        WalkThroughDTO[] walkThroughsArray = new WalkThroughDTO[walkThroughs.size()];
        startingCell = render(walkThroughs.toArray(walkThroughsArray), startingCell);
        
                //need to do the rest for ChangeOrderDTO and WalkThroughs
                //rught now, staring cell is just below the last "balance to complete"
                // lable in the last DrawRequestDTO
    }
    
    public byte[] saveDocument() throws IOException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            wb.write(baos);
            return baos.toByteArray();
//        File file = new File(fileName + ".xlx");
//        FileOutputStream fileOut = null;
//        fileOut = new FileOutputStream(file);
//        wb.write(fileOut);    
//        fileOut.close();
//        return file;
    }
    
    private Cell render(ChangeOrderDTO[] changeOrders, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        
        String[] headers = {
            "Sub contractor",
            "amount",
            "description",
            "executed?"
        };
        
        
        for (int i = 0; i < headers.length; i++) {
            startingCell.setCellValue(createHelper.createRichTextString(headers[i]));
            startingCell = moveCellRight(startingCell, sheet, 1);
        }
        startingCell = moveCellRight(startingCell, sheet, headers.length * -1);
        startingCell = moveCellDown(startingCell, sheet, 1);
        
        for (int i = 0; i < changeOrders.length; i++) {
            render(changeOrders[i], sheet, startingCell);
            startingCell = moveCellDown(startingCell, sheet, 1);
        }
        
        return moveCellDown(startingCell, sheet, changeOrders.length);
    }
    
    private void render(ChangeOrderDTO changeOrder, Sheet sheet, Cell startingCell) {
        CreationHelper createHelper = wb.getCreationHelper();
        String executed;
        if (changeOrder.isExecuted()) {
            executed = "Yes";
        } else {
            executed = "no";
        }
        String[] values = {
            changeOrder.getSubContractor(),
            changeOrder.getAmount()+"",
            changeOrder.getDescription(),
            executed
        };
        
        for (int i = 0; i < values.length; i++) {
            startingCell.setCellValue(createHelper.createRichTextString(values[i]));
            startingCell = moveCellRight(startingCell, sheet, 1);
        }
        startingCell = moveCellRight(startingCell, sheet, values.length * -1);
    }
    
    private Cell render(DrawRequestDTO drawRequest, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        String[] rowTitles = {
            "amount",
            "max request to date",
            "min request to date",
            "retainage rel",
            "contingency draw",
            "contingency balance",
            "balance to complete",
        };
        String[] rowValues = new String[rowTitles.length];
            rowValues[0] = drawRequest.getCurrentRequest().toString();
            if (drawRequest.getMaxRequest() != null)  
                rowValues[1] = drawRequest.getMaxRequest().toString();
            if (drawRequest.getMinRequest() != null)
                rowValues[2] = drawRequest.getMinRequest().toString();
            if (drawRequest.getRetainageRel() != null) 
                rowValues[3] = drawRequest.getRetainageRel().toString();
            if (drawRequest.getContigencyDraw() != null) 
                rowValues[4] = drawRequest.getContigencyDraw().toString();
            if (drawRequest.getContingencyBalance() != null)
                rowValues[5] = drawRequest.getContingencyBalance().toString();
            if (drawRequest.getBalanceToComplete() != null)
                rowValues[6] = drawRequest.getBalanceToComplete().toString();
        
        for (int i = 0; i < rowTitles.length; i++) {
            startingCell.setCellValue(createHelper.createRichTextString(rowTitles[i]));
            startingCell = moveCellRight(startingCell, sheet, 1);
            startingCell.setCellValue(createHelper.createRichTextString(rowValues[i]));
            startingCell = moveCellRight(moveCellDown(startingCell, sheet, 1), sheet, -1);
        }
        
        return startingCell;
        
    }
    
    private Cell render(WalkThroughDTO[] walkThroughs, Cell startingCell) {
        Sheet sheet = wb.getSheetAt(0);
        CreationHelper createHelper = wb.getCreationHelper();
        
        String[] headers = {
            "floor",
            "trade",
            "progress",
            "comments"
        };

        Row headerRow  = sheet.createRow(startingCell.getRowIndex());
        Cell cell;
        for (int i = 0; i < headers.length; i++) {
            cell = headerRow.createCell(startingCell.getColumnIndex()+i);
            cell.setCellValue(createHelper.createRichTextString(headers[i]));
        }
        
        startingCell = moveCellDown(startingCell, sheet, 1);
        
        for (int i = 0; i < walkThroughs.length; i++) {
            render(walkThroughs[i], sheet, startingCell);
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
