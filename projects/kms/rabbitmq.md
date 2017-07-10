# Rabbitmq

## Install RabbitMQ on Ubuntu 14.04  
- sudo apt install -y rabbitmq-server
- git clone
- sudo autoreconf -i
- sudo ./configure --libdir=/usr/lib/x86_64-linux-gnu --prefix=/usr --includedir=/usr/include --disable-gtk-doc --host=x86_64-linux-gnu
- sudo vi Makefile  
  - ldflags => -lpthread 추가
- sudo make -j4
- sudo make install  

##
