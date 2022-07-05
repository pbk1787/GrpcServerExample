package com.test.demo;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import room.Hello.CreateRoomReply;
import room.Hello.CreateRoomRequest;
import room.Hello.GetRoomsReply;
import room.Hello.GetRoomsRequest;
import room.Hello.Room;
import room.RoomServiceGrpc.RoomServiceImplBase;

//SimpleGrpc.SimpleImplBase
@GrpcService
public class GrpcServerService extends RoomServiceImplBase {
	
	@Override
	public void getRooms(GetRoomsRequest request, StreamObserver<GetRoomsReply> responseObserver) {
		
		System.out.println("##@@#@#@#@#@#@");
		
		System.out.println("도착!!!!!");
		
		Room room = Room.newBuilder()
				.setSid("sid")
				.setName("NewRoom")
				.setLock(false)
				.setDescription("new room")
				.setMaxPeers(10)
				.build();
		
		GetRoomsReply reply = GetRoomsReply.newBuilder()
				.setSuccess(true)
				.addRooms(room)
//				.setRooms(0, room)
				.build();
		
		responseObserver.onNext(reply);
        responseObserver.onCompleted();
		
	}
	
	@Override
	public void createRoom(CreateRoomRequest request, StreamObserver<CreateRoomReply> responseObserver) {
		// TODO Auto-generated method stub
//		super.createRoom(request, responseObserver);
		
		System.out.println("도착!!!!!!");
		
		System.out.println(request.getAllFields());
		
//		System.out.println(request.getAllFields().get());
		
	}
	
	

}
