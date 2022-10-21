# gRPC-road-control
Consider a scenario of a road, Figure 1a), with five access points allowing vehicle entrances and/or exits, including the possibility of a vehicle entering and exiting at the same point. The road has stops with payment depending on the route taken, according to a price list identical to the one shown in Figure 1b).

<p align="center">
  <img src="https://user-images.githubusercontent.com/47757441/185813685-6bf2fceb-da5a-4f2c-b1ae-257200d79436.jpg" width="700">
</p>

During a journey, a vehicle can issue or receive warnings about events, for example, regarding objects on the road, animals, etc. When the server receives a warning, it broadcasts it to all vehicles (clients) that are connected, that is, that entered the road.

This repository consists on three main projects, the **_car-client_**, the **_road-server-control_** and the **_central-server_**. The *road-server-control*, has the role of managing who enters/exits the road. It has the capability of broadcasting warning messages to clients currently on the road that are registered to receive events. The _central-server_ has the single functionality of assigning a tariff depending on the route made by the car (point A to point B). Figure 2 ilustrates the described scenario.

<p align="center">
  <img src="https://user-images.githubusercontent.com/47757441/185813692-5f247668-865e-48a4-a397-4807eb298f28.jpg" width="450">
</p>

The servers communicate with each other using the framework _gRPC_ (Google Remote Procedure Call). The Java project was built with the help of _Apache Maven_. The contracts established between the servers (`.proto` files), can be found inside the projects _road-contract_ (_car-client_ <-> _road-server-control_) and the _central-contract_ (_road-server-control_ <-> _central-server_).
