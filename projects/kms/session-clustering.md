# webrtc socket reuse references


https://stackoverflow.com/questions/32047777/how-can-webrtc-reconnect-to-the-same-peer-after-disconnection
https://stackoverflow.com/questions/30401984/is-it-possible-to-maintain-webrtc-connection-after-disconnecting-from-the-intern

# libnice install

- git clone -b kms6.6.0 https://github.com/lunker/libnice.git
- cd libnice
- ./autogen.sh --disable-gtk-doc
- sudo ./configure --libdir=/usr/lib/x86_64-linux-gnu --prefix=/usr --includedir=/usr/include --disable-gtk-doc --host=x86_64-linux-gnu
- sudo make -j4 install

# libnice

- <agent.c> nice_agent_gather_candidates()
{
- agent_find_stream () 수행 :: stream_id가 존재해야함.
- discovery에서 candidate를 수집한다.
- 이때, NiceCandidate를 만들고, transport를 이용하여 socket을 만든다.
  - socket type : udp, tcp,  . . .
-
}

==============
# TODO

[store session info]
- local, remote candidate
- transport state
- nice_agent state
- nice_component state

[set use-ice-tcp disable  ]


# kms with keepalived

- rtp
kms_sdp_agent_origin_init에서 c= 에 ip를 넣는다.

- webrtc
gather_candidate를 할 때에 넣는다.


=============
# Flow

<libnice>
- gather candidates

  - connection check
  - exclude agent_signal_new_candidate
  - signal gathering done

- gatehring done
  -
===
<elements>
- 똑같이, process_offer를 하고서 start한다.
- 즉, core단에서는 kurento logic을 타면서 sdp를 생성하고 셋팅한다.
- 이후에 elements단에서 webrtc에 부가적으로 필요한 것을 수행한다.
- 아래의 start_transport_send를 통해서 candidate를 체크한다.

??process_offer를 할때에, neg_sdp를 셋팅한다. 근데 이게 과연 딱 협상된, 1개인가? 체크를 해야한다. 이건 core단에서 체크해야함??

xxxxx_process_offer
->kms_webrtc_endpoint_start_transport_send
->kms_webrtc_session_start_transport_send
->gst_media_add_remote_candidates
->kms_webrtc_session_add_ice_candidate
->kms_webrtc_session_set_remote_ice_candidate
->kms_ice_base_agent_add_ice_candidate
->kms_ice_nice_agent_add_ice_candidate
->nice_agent_set_remote_candidates :: set remote candidates.
-> _set_remote_candidates_locked
-> conn_check_remote_candidates_set()


?kms_webrtc_session_set_remote_ice_candidate?

<elements>
create offer


=======
glossary

Component:  A component is a piece of a media stream requiring a
      single transport address; a media stream may require multiple
      components, each of which has to work for the media stream as a
      whole to work.  For media streams based on RTP, there are two
      components per media stream -- one for RTP, and one for RTCP.

Gathering ICE Candidate :: create local candidate. not remote.

ICE connectivity ? Negotiation



=======


1) priv_mark_pair_nominated



2) priv_map_reply_to_conn_check_request



priv_mark_pair_nominated or priv_map_reply_to_conn_check_request
->priv_update_selected_pair()
->agent_signal_new_selected_pair()




=============== libnice
./nice/libnice.sym ㅇ에다가 새로운 메소드 추가해줘야함!!!!!
