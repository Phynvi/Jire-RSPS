package jire.packet.build;

import jire.packet.Packet;
import jire.packet.PacketBuilder;
import jire.packet.PacketRepresentation;
import jire.packet.RSOutputStream;
import jire.packet.reflective.BuildsPacket;
import jire.packet.represent.HandshakeResponsePacket;

@BuildsPacket(HandshakeResponsePacket.class)
public class HandshakeResponseBuilder implements PacketBuilder {

	@Override
	public Packet build(PacketRepresentation packetRep) {
		HandshakeResponsePacket packet = (HandshakeResponsePacket) packetRep;

		RSOutputStream output = new RSOutputStream(8 + 1 + 8);
		output.writeLong(0);
		output.write(packet.getResponseCode());
		output.writeLong(packet.getSessionKey());

		return new Packet(output.getData());
	}

}