

```plantuml
@startuml
left to right direction
title Create a project use case
actor "Project Leader" as pl
actor "Worker" as wo
actor "Software huset A/S" as sh


rectangle System {
  usecase "Create project" as UC7
  
pl --> UC7
sh --> UC7
wo --> UC7

}


@enduml
```