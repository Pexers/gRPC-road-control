# gRPC-road-control
Consider a scenario of a road, figure 1a), with 5 access points allowing vehicle entrances and/or exits, including the possibility of a vehicle entering and exiting at the same point. The road has tolls with payment depending on the route taken according to a price list identical to the one shown in figure 1b).

During a journey a vehicle can issue or receive warnings about events, for example objects on the road, animals, etc. When the server receives a warning, it broadcasts it to all vehicles (clients) that are connected, that is, that entered on the road.

<p align="center">
  <img src="https://github.com/Pexers/gRPC-road-control/blob/main/images/figure1.jpg" width="650">
</p>

This repository consists on three main projects, the car-client, the road-server-control and the central-server. The road-server-control has the role of managing who enters/exits the road and also has the capability of **broadcasting** warning messages to the clients that are registered for events and that are currently on the road. The central-server has one single functionality of assigning a tariff depending on the route (point A to point B). Figure 2 ilustrates this scenario.

<p align="center">
  <img src="https://github.com/Pexers/gRPC-road-control/blob/main/images/figure2.jpg" width="450">
</p>

The servers interact using the framework **gRPC (Google Remote Procedure Call)**. The libraries were imported with help of **Maven**. The contracts established between the servers **(.proto files)** can be found inside the projects road-contract (car-client <-> road-server-control) and central-contract (road-server-control <-> central-server)
