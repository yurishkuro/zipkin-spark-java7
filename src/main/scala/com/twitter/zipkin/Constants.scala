package com.twitter.zipkin

object Constants {
  val ClientSend: String = "cs"
  val ClientSendFragment: String = "csf"
  val ClientRecv: String = "cr"
  val ClientRecvFragment: String = "crf"
  val ServerSend: String = "ss"
  val ServerSendFragment: String = "ssf"
  val ServerRecv: String = "sr"
  val ServerRecvFragment: String = "srf"
  val ClientAddr: String = "ca"
  val ServerAddr: String = "sa"
  val WireSend: String = "ws"
  val WireRecv: String = "wr"
  val LocalComponent: String = "lc"

  val CoreClient: Set[String] = Set(ClientSend, ClientSendFragment, ClientRecv, ClientRecvFragment)
  val CoreServer: Set[String] = Set(ServerRecv, ServerRecvFragment, ServerSend, ServerSendFragment)
  val CoreAddress: Set[String] = Set(ClientAddr, ServerAddr)
  val CoreWire: Set[String] = Set(WireSend, WireRecv)
  val CoreLocal: Set[String] = Set(LocalComponent)

  val CoreAnnotations: Set[String] = CoreClient ++ CoreServer ++ CoreWire ++ CoreLocal

  val CoreAnnotationNames: Map[String, String] = Map(
    ClientSend -> "Client Send",
    ClientSendFragment -> "Client Send Fragment",
    ClientRecv -> "Client Receive",
    ClientRecvFragment -> "Client Receive Fragment",
    ServerSend -> "Server Send",
    ServerSendFragment -> "Server Send Fragment",
    ServerRecv -> "Server Receive",
    ServerRecvFragment -> "Server Receive Fragment",
    ClientAddr -> "Client Address",
    ServerAddr -> "Server Address",
    WireSend -> "Wire Send",
    WireRecv -> "Wire Receive",
    LocalComponent -> "Local Component"
  )

  /* 127.0.0.1 */
  val LocalhostLoopBackIP = (127 << 24) | 1
}
