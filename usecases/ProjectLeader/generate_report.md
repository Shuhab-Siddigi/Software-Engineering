
```plantuml
@startuml

left to right direction
title Use Case :Generate Report 
actor "Project Leader" as pl

rectangle System {
  usecase "Generate report" as UC10
}

pl --> UC10

@enduml
```