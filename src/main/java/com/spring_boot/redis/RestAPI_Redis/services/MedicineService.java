package com.spring_boot.redis.RestAPI_Redis.services;

import com.spring_boot.redis.RestAPI_Redis.models.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MedicineService {
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY="medicine";

    @Autowired
    public MedicineService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //save medicine
    public Medicine save(Medicine medicine){
        redisTemplate.opsForHash().put(KEY,medicine.getId(),medicine);
        return medicine;
    }
    //get medicine by Id
    public Medicine getMedicineById(String id){
        Object re=redisTemplate.opsForHash().get(KEY,id);
        return (Medicine) re;
    }
    //get all the medicines
    public List<Medicine> getAllMedicines(){
        Map<Object,Object>result=redisTemplate.opsForHash().entries(KEY);
        Collection<Object> values=result.values();
        return values.stream().map(value->(Medicine)value).collect(Collectors.toList());
    }
    //delete medicine By Id
    public void deleteMedicineById(String id){
        redisTemplate.opsForHash().delete(KEY,id);
    }
    //update medicine by id.
    public Medicine updateMedicineById(String id,Medicine updatedMedicine){
        Medicine medicine=getMedicineById(id);
        if(medicine!=null){
            medicine.setName(updatedMedicine.getName());
            medicine.setCompanyName(updatedMedicine.getCompanyName());
            medicine.setExpiry(updatedMedicine.getExpiry());
            medicine.setCount(updatedMedicine.getCount());
            return save(medicine);
        }
        throw new RuntimeException("Not found medicine with id:"+id);
    }
}
