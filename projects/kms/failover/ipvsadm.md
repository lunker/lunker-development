#
</etc/sysctl.conf>
net.ipv4.conf.lo.arp_ignore = 1
net.ipv4.conf.lo.arp_announce = 2
net.ipv4.conf.all.arp_ignore = 1
net.ipv4.conf.all.arp_announce = 2

- sudo ipvsadm -A -t 10.0.1.195:8888 -s rr
- sudo ipvsadm -a -t 10.0.1.195:8888 -r 10.0.1.110:8888 -g -w 1
- sudo ipvsadm -a -t 10.0.1.195:8888 -r 10.0.1.159:8888 -g -w 1
<save ipvsadm settings>
- sudo sh -c 'ipvsadm-save | tee /etc/ipvsadm.rules'

# Reference
- https://ani2life.com/wp/?p=1205
