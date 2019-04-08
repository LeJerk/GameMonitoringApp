package com.jpj.enjoy.game.monitoring.controller;

import com.jpj.enjoy.game.monitoring.model.Service;
import com.jpj.enjoy.game.monitoring.model.ServiceTableField;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class Dashboard {

  @GetMapping("/services")
  public List<Service> getServices() {
    return mockServicesData();
  }

  @GetMapping("/services/fields")
  public List<ServiceTableField> getServicesFields() {
    return mockTableFields();
  }

  private List<Service> mockServicesData() {
    List<Service> services = new ArrayList<>();
    services.add(generateServiceData("Freespin Game", 40, 4000, 440));
    services.add(generateServiceData("Freespin Account", 55, 1500, 200));
    services.add(generateServiceData("Game Filter", 100, 3300, 500));
    services.add(generateServiceData("Game Admin", 10, 15, 5));
    services.add(generateServiceData("Game DataHub", 80, 400, 300));

    return services;
  }

  private Service generateServiceData(String system, int active, int logs, int errors) {
    Service service = new Service();
    service.setSystem(system);
    service.setActiveModules(active);
    service.setLogsPerSecond(logs);
    service.setTodaysErrorLogs(errors);

    return service;
  }

  private List<ServiceTableField> mockTableFields() {
    List<ServiceTableField> tableFields = new ArrayList<>();
    tableFields.add(generateTableField("system", "Service", ""));
    tableFields.add(generateTableField("activeModules", "Active Modules", ""));
    tableFields.add(generateTableField("logsPerSecond", "Logs/s", "info"));
    tableFields.add(generateTableField("todaysErrorLogs", "Errors today", "danger"));

    return tableFields;
  }

  private ServiceTableField generateTableField(String key, String label, String variant) {
    ServiceTableField field = new ServiceTableField();
    field.key = key;
    field.label = label;
    field.variant = variant;

    return field;
  }
}
