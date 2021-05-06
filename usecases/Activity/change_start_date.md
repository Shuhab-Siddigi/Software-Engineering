```plantuml
@startuml
left to right direction
title Change start date for activity use case
actor "Project Leader" as pl
actor "Worker" as wo

rectangle System {
  usecase "Change start date" as UC2
  
pl --> UC2
wo --> UC2

}


@enduml
```

