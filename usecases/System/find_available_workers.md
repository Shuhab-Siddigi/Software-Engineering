

```plantuml
@startuml
left to right direction
title Finding available workers use case
actor "Project Leader" as pl
actor "Worker" as wo
actor "Software huset A/S" as sh


rectangle System {
  usecase "Find available workers" as UC15

pl --> UC15
sh --> UC15
wo --> UC15

}


@enduml
```

