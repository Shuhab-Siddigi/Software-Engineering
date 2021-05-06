```plantuml
@startuml
left to right direction
title Manage project use case
actor "Project Leader" as pl
actor "Worker" as wo


rectangle System {
  usecase "Remove activity" as UC4
pl --> UC4
wo --> UC4
}


@enduml
```
