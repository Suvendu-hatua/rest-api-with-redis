package com.spring_boot.redis.RestAPI_Redis.controller;

import com.spring_boot.redis.RestAPI_Redis.models.Medicine;
import com.spring_boot.redis.RestAPI_Redis.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class MedicineController {
    private MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    //GET
    @GetMapping("/medicine")
    public ResponseEntity<List<Medicine>> getAllMedicines(){
        return ResponseEntity.ok(medicineService.getAllMedicines());
    }
    //GET BY ID
    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable String id){
       Medicine medicine= medicineService.getMedicineById(id);
       if(medicine!=null){
           return ResponseEntity.ok(medicine);
       }
       return ResponseEntity.notFound().build();
    }
    //POST
    @PostMapping("/medicine")
    public ResponseEntity<?> addMedicine(@RequestBody Medicine medicine){
        medicine.setId(UUID.randomUUID().toString());
        try{
            medicine=medicineService.save(medicine);
            return new ResponseEntity<>(medicine,HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //PUT
    @PutMapping("/medicine/{id}")
    public ResponseEntity<?> updateMedicine(@PathVariable String id,@RequestBody Medicine medicine){
        try{
            medicine= medicineService.updateMedicineById(id, medicine);
            return ResponseEntity.ok(medicine);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //DELETE
    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<?> deleteMedicineById(@PathVariable String id){
        try{
            medicineService.deleteMedicineById(id);
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
