package uz.najot.order.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.najot.order.entity.ProductEntity;
import uz.najot.order.model.DeliveryModel;
import uz.najot.order.repository.DeliveryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final DeliveryRepository deliveryRepository;
    public void pay(String message){
        Gson gson = new Gson();
        DeliveryModel model = gson.fromJson(message, DeliveryModel.class);
        Optional<ProductEntity> deliveryOptional = deliveryRepository.findById(model.getId());
        ProductEntity product = deliveryOptional.get();
        product.setCount(product.getCount() - model.getCount());
        deliveryRepository.save(product);
    }
}
