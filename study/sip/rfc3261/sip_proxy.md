# proxy(rfc 3261, section 16)


### proxy behavior
    1.  Make a copy of the received request
    2.  Update the Request-URI
    3.  Update the Max-Forwards header field
    4.  Optionally add a Record-route header field value
    5.  Optionally add additional header fields
    6.  Postprocess routing information
    7.  Determine the next-hop address, port, and transport
    8.  Add a Via header field value
    9.  Add a Content-Length header field if necessary
    10. Forward the new request
    11. Set timer C

    8.  Add a Via header field value
    9.  Add a Content-Length header field if necessary
    10. Forward the new request
    11. Set timer C

**참고**
- rfc 3261, 16
-
