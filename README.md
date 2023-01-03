# gRPC Road Control 🚗
Consider the scenario of a road represented in Figure 1a), where there're five access points to allow entrances and/or exits of vehicles, including the possibility of a vehicle entering and exiting at the same access point. The road has stops with payments depending on the route taken, according to a price list identical to the one shown in Figure 1b).

<p align="center">
  <img src="https://user-images.githubusercontent.com/47757441/185813685-6bf2fceb-da5a-4f2c-b1ae-257200d79436.jpg" width="700">
</p>

A vehicle can issue or receive warning events regarding, for instance, objects on the road, animals, or any other type of adversity. When the server receives a warning, it broadcasts it to all vehicles (clients) that are connected, that is, that entered the road.

This repository consists on three main projects, the **_car-client_**, the **_road-server-control_** and the **_central-server_**. The *road-server-control*, has the role of managing who enters/exits the road. It also has the capability of broadcasting warning events to clients currently on the road that are registered to receive them. The _central-server_ has the single functionality of assigning a tariff depending on the route made by a car (from point A to point B). _Figure 2_ ilustrates this scenario.

<p align="center">
  <img src="https://user-images.githubusercontent.com/47757441/185813692-5f247668-865e-48a4-a397-4807eb298f28.jpg" width="450">
</p>

The servers communicate with each other using the **gRPC framework** (Google Remote Procedure Call). Java projects were built with the help of _Apache Maven_. The contracts established between servers (`.proto` files), can be found inside the projects _road-contract_ (_car-client_ <-> _road-server-control_) and the _central-contract_ (_road-server-control_ <-> _central-server_).
