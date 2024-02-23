package app;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class FileWriteService {
    public String toFile(String text, String fileName) throws IOException {
        FileChannel fileChannel;
        try (FileOutputStream fout =
                     new FileOutputStream(Const.BASE_PATH + fileName + ".txt")) {
            byte[] arr = text.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(arr.length);
            buffer.put(arr);
            fileChannel = fout.getChannel();
            buffer.flip();
            fileChannel.write(buffer);
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        }catch (FileNotFoundException e) {
            return e.getMessage();
        }
        fileChannel.close();
        return "File created!";
    }
}
