http://manywaypark.tistory.com/entry/core-file%EC%9D%80-%EC%96%B4%EB%94%94%EC%97%90

https://groups.google.com/forum/#!msg/kurento/BEvVU2_BrEM/pm77AfAiX6oJ

- install apport
sudo apt install -y apport

ulimit -c unlimited

apport-unpack <dump file>
gdb <binary> <unpacked core dump>
