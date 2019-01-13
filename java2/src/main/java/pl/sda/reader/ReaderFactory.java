package pl.sda.reader;

import pl.sda.writer.FileType;

public class ReaderFactory {

    public Readable generate(FileType fileType) {
        if (FileType.CSV == fileType) {
            return new CsvReader();
        } else {
            return new JsonReader();
        }
    }

}
