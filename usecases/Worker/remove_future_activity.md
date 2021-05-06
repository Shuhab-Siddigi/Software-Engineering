

```plantuml
@startuml
left to right direction
title Manage project use case
actor "Project Leader" as pl
actor "Worker" as wo

rectangle System {

  usecase "Remove future activity" as UC14
  
pl --> UC14

wo --> UC14

}


@enduml
```

