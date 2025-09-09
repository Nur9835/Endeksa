package utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;
    private String path;

    public ExcelUtils(String path, String sheetName){
        this.path = path;
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCellData(int rowNum,int colNum){
        Cell cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.toString();
    }


    public int rowCount(){
        return  sheet.getLastRowNum();
    }
    int columnCount(){
        return sheet.getRow(0).getLastCellNum();
    }
    //

    public String[][] getDataArray() {
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 1; i <=rowCount() ; i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i,j);
                data[i-1][j]=value;
            }
        }
        return data;
    }

    public List<String> getColumnsNames() {
        List<String> columns = new ArrayList<>();
        for (Cell cell : sheet.getRow(0)) {
            columns.add(cell.toString());
        }
        return columns;
    }

    public void setCellData(String value, int rowNum, int colNum) {
        try {
            sheet.getRow(rowNum).createCell(colNum).setCellValue(value);
            FileOutputStream fos = new FileOutputStream(path);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCellData(String value, String columnName, int row) {
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }
}