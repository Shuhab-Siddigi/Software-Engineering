

```plantuml
@startuml
left to right direction
title Manage project use case
actor "Project Leader" as pl
actor "Worker" as wo

rectangle System {
  usecase "Add future activity" as UC11  
  
pl --> UC1
wo --> UC1

}


@enduml
```

