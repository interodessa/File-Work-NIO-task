package app;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import static app.Const.BASE_PATH;

public class FileReadService {
    public String fromFile(String file) throws IOException {
        FileChannel channel;
        StringBuilder builder;
        try (FileInputStream fis = new FileInputStream(BASE_PATH + file + ".txt")) {
            channel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(128);
            builder = new StringBuilder();
            while (channel.read(buffer) != -1) {
                buffer.flip();
                builder.append(Charset.defaultCharset().decode(buffer));
                // Готуємо буфер для запису
                buffer.clear();
            }
        } catch (IOException ex) {
            return ex.getMessage();
        }
        channel.close();
        return builder.toString();
    }
}
