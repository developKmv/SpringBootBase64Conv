package ru.base64utils;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component("func")
public class Base64Func {

    private static Logger log = (Logger) LoggerFactory.getLogger(Base64Func.class);

    private File file;

    public Base64Func(){};

    public Base64Func(File file){
        this.file = file;
    };

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void encode64() throws IOException {
        String result = "no data";
        File outputEncode64 = new File("output_encode_64");
        log.debug(String.format("function encode64 start file %s: ",file.toString()));

        try(RandomAccessFile reader = new RandomAccessFile(file, "r");
            FileChannel channel = reader.getChannel();
            RandomAccessFile writer = new RandomAccessFile(outputEncode64, "rw");
            ByteArrayOutputStream out = new ByteArrayOutputStream())
        {
            int bufferSize = 1024;

            if (bufferSize > channel.size()) {
                bufferSize = (int) channel.size();
            }
            ByteBuffer buff = ByteBuffer.allocate(bufferSize);

            while (channel.read(buff) > 0) {
                out.write(buff.array(), 0, buff.position());
                buff.clear();
            }
            result = Base64.getEncoder().encodeToString(out.toByteArray());
            writer.write(result.getBytes(StandardCharsets.UTF_8));
            log.debug(String.format("function encode64 is complete result length :",result.length()));
        }
    }
}
