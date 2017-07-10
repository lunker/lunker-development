# Kurento Client Release

##
- MediaSet::release() : kurento objectId를 이용하여 해당 object와 관련있는 element들의 reference들을 다 삭제한다.
그래서 destructor가 호출되도록 한다.  
