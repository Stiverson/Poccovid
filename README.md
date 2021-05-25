# Pocovid - Backend

Step-by-step setup tutorial of the Pocovid backend.
>
>The tutorial assumes that the user's OS is LINUX based, *if not make the appropriate changes and select the correct OS in the documentation*.
>
>If running on Windows remember to enable Hyper-V and virtual environments.


#### Pre Requiments
* [Docker](https://docs.docker.com/engine/install/debian/)
> create docker group, *you'll probably have to reboot after this*.

sudo groupadd docker

sudo usermod -aG docker $USER

#### Git clone
>[Clone the project](https://github.com/Stiverson/Poccovid) and go to the chosen directory, for example:

git clone https://github.com/Stiverson/Poccovid.git

#### Deploy
>First deploy

docker-compose up --build

>Regular Deploy

docker-compose up