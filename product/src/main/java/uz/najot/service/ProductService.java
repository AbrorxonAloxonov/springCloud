package uz.najot.service;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.najot.entity.ProductEntity;
import uz.najot.model.ProductModel;
import uz.najot.repository.ProductRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final static ConnectionFactory connectionFactory = new ConnectionFactory();
    private static Channel chanel = null;
    private final ProductRepository productRepository;
    public ResponseEntity saveProduct(ProductEntity product) throws IOException, TimeoutException {

        Optional<ProductEntity> baseProduct = productRepository.findByNameAndPrice(product.getName(), product.getPrice());
        if (baseProduct.isPresent()) {
            Integer integer = baseProduct.get().getId();
            product.setId(integer);
            product.setCount(baseProduct.get().getCount() + product.getCount());
        }
        Integer id = productRepository.save(product).getId();
        Gson gson = new Gson();
        ProductModel productModel = new ProductModel();
        productModel.setId(id);
        productModel.setCount(product.getCount());
        productModel.setTrade("+");
        String json = gson.toJson(productModel);
        Connection connection = connectionFactory.newConnection();
        AMQP.BasicProperties builder = new AMQP.BasicProperties().builder().contentType("application/text").build();
        chanel = connection.createChannel();
        chanel.basicPublish("cloud_exchange", "null.history", builder, json.getBytes());

        return ResponseEntity.ok("Save");
    }

    public ResponseEntity getAllProduct(){
        return ResponseEntity.ok(productRepository.findAll());
    }
    public ResponseEntity payProduct(ProductModel productModel) throws IOException, TimeoutException {
        Optional<ProductEntity> productOptional = productRepository.findById(productModel.id);
        if (productOptional.get().getCount() >= productModel.getCount()) {
            Gson gson = new Gson();
            productModel.setTrade("-");
            String json = gson.toJson(productModel);
            Connection connection = connectionFactory.newConnection();
            AMQP.BasicProperties builder = new AMQP.BasicProperties().builder().contentType("application/text").build();
            chanel = connection.createChannel();
            chanel.basicPublish("cloud_exchange","order.history",builder,json.getBytes());
            return ResponseEntity.ok("Price  " + productModel.getCount()*productOptional.get().getPrice());
        }
        return ResponseEntity.ok("Mahsulot soni do'konda yetarli emas");
    }

}
