//package com.yu.ysblog.config;
//
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import org.springframework.boot.jackson.JsonComponent;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
///**
// * @Author yu
// * @DateTime 2021/8/8 0:28
// */
//@JsonComponent
//public class DateFormatConfig {
//    /**
//     * 响应json日期格式化
//     */
//    public static class DateJsonSerializer extends JsonSerializer<Date> {
//        @Override
//        public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            jsonGenerator.writeString(localDateTime.format(formatter));
//        }
//    }
//
//    /**
//     * 解析json请求日期字符串
//     */
//    public static class DateJsonDeserializer extends JsonDeserializer<LocalDateTime> {
//        @Override
//        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//            return LocalDateTime.parse(jsonParser.getText());
//        }
//    }
//
//}
