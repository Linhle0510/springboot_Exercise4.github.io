package com.example.stream_api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import com.example.stream_api.model.Person;
import com.example.stream_api.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PeopleController {
  @Autowired
  private PersonRepository personRepo;
// 2.1 Nhóm những người trong cùng thành phố lại
  @GetMapping("groupbycity")
  public ResponseEntity<Map<String, List<Person>>> groupByCity() {
    return ResponseEntity.ok().body(personRepo.groupPeopleByCity());
  }

  @GetMapping("groupbycity2")
  public Map<String, List<Person>> groupByCity2() {
    return personRepo.groupPeopleByCity(); // mặc nhiên trả về status code 200, và chỉ trả dữ liệu
  }

  @GetMapping("groupbycitythencount")
  public ResponseEntity<Map<String, Long>> groupByCityThenCount() {
    return ResponseEntity.ok().body(personRepo.groupByCityThenCount());
  }
// 2.2 Nhóm các nghề nghiệp và đếm số người làm
  @GetMapping("groupbyjobthencount")
  public ResponseEntity<Map<String, Long>> groupByJobThenCount() {
    return ResponseEntity.ok().body(personRepo.groupByJobThenCount());
  }
// 2.3 Tìm 5 nghề có nhiều người làm nhất, đếm từ cao xuống thấp
  @GetMapping("fivetopjobs")
  public ResponseEntity<Map<String, Long>> fiveTopJobs() {
    return ResponseEntity.ok().body(personRepo.fiveTopJobs());
  }
    // 2.4 Tìm 5 thành phố có nhiều người trong danh sách ở nhất, đếm từ cao xuống
    // thấp
  @GetMapping("fivetoppopcities")
  public ResponseEntity<Map<String, Long>> fiveTopPopulationCities() {
    return ResponseEntity.ok().body(personRepo.fiveTopPopulationCities());
  }

  // 2.5 Trong mỗi thành phố, hãy tìm ra nghề nào được làm nhiều nhất
  @GetMapping("topjobcity")
  public ResponseEntity<Map<String, Map.Entry<String, Long>>> topJobByNumerInEachCity() {
    return ResponseEntity.ok().body(personRepo.topJobByNumerInEachCity());
  }

  // 2.6 Ứng với một nghề, hãy tính mức lương trung bình
  @GetMapping("averagesalary")
  public ResponseEntity<Map<String, Double>> averageSalaryByJob() {
    return ResponseEntity.ok().body(personRepo.averageSalaryByJob());
  }

  // 2.7 Năm thành phố có mức lương trung bình cao nhất
  @GetMapping("5citistopsalary")
  public  ResponseEntity<java.util.Map<String, Double>> fiveCitiesHasTopAverageSalary() {
    return ResponseEntity.ok().body(personRepo.fiveCitiesHasTopAverageSalary());
  }

  // 2.8 Năm thành phố có mức lương trung bình của developer cao nhất
  @GetMapping("5citistopdevsalary")
  public ResponseEntity<Map<String, Double>> fiveCitiesHasTopSalaryForDeveloper() {
    return ResponseEntity.ok().body(personRepo.fiveCitiesHasTopSalaryForDeveloper());
  }

  // 2.9 Tuổi trung bình từng nghề nghiệp
  @GetMapping("averageageperjob")
  public ResponseEntity<Map<String, Double>> averageAgePerJob() {
    return ResponseEntity.ok().body(personRepo.averageAgePerJob());
  }
// 2.10 Tuổi trung bình ở từng thành phố
@GetMapping("averageagepercity")
  public ResponseEntity<Map<String, Double>> averageAgePerCity() {
    return ResponseEntity.ok().body(personRepo.averageAgePerCity());
  }
  // 2.11 Tuổi cao nhất ở mỗi thành phố
  @GetMapping("maxagepercity")
  public ResponseEntity<List<Entry<String, Integer>>> maxAgePerCity() {
    return ResponseEntity.ok().body(personRepo.maxAgePerCity());
    
  }

  // 2.12 tỷ lệ nam / nữ trong toàn bộ dữ liệu
  @GetMapping("malefemaleratio")
  public ResponseEntity<Double> maleFemaleRatio() {
    return ResponseEntity.ok().body(personRepo.maleFemaleRatio());
  }
  //2.13 Tìm thành phố có số lượng lập trình viên cao nhất
  @GetMapping("cityHasMaxNumberOfDeveloper")
public ResponseEntity<Map<Object, Object>> cityHasMaxNumberOfDeveloper(){
  return ResponseEntity.ok().body(personRepo.cityHasMaxNumberOfDeveloper());
}

//2.14 Tính tỷ lệ nam/nữ ở mỗi thành phố
@GetMapping("malefemaleRatioInEachCity")
public ResponseEntity<Object> malefemaleRatioInEachCity() {

   return ResponseEntity.ok().body(personRepo.malefemaleRatioInEachCity());
}

}
