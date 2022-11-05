package uz.najot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel{
    public Integer id;
    public Double count;
    public String trade;

}
