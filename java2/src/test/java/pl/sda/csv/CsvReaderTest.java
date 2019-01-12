package pl.sda.csv;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.fail;

public class CsvReaderTest {

    @Test
    public void readAndPrintContentFromCsv() {
        //given
        CsvReader csvReader = new CsvReader();
        try {
            //when
            csvReader.readAndPrintContentFromEmployeeCsv();
        } catch (IOException e) {
            fail();
        }
        //then no exp
    }
}