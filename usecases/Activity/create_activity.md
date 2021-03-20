

```plantuml
@startuml
left to right direction
title Create activity use case
actor "Project Leader" as pl
actor "Worker" as wo

rectangle System {
  usecase "Create activity" as UC3
pl --> UC3
wo --> UC3

}


@enduml
```

