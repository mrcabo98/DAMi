package cat.itb.P1.EJ01_CABO_MARC_M06;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStrem extends ObjectOutputStream {

    public MyObjectOutputStrem(OutputStream out) throws IOException {
        super(out);
    }

    protected MyObjectOutputStrem() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {

    }
}
