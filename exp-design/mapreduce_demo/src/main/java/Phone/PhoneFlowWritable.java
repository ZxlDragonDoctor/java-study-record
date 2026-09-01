package Phone;



import lombok.Data;
import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


@Data
public class PhoneFlowWritable implements Writable {
    private String phonenumber;
    private int downflow;

    private int upflow;

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.phonenumber);
        dataOutput.writeInt(this.upflow);
        dataOutput.writeInt(this.downflow);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.phonenumber = dataInput.readUTF();
        this.upflow = dataInput.readInt();
        this.downflow = dataInput.readInt();
    }
}
