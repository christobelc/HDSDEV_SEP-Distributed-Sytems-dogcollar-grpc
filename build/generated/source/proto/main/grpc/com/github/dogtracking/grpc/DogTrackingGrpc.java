package com.github.dogtracking.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: dogtracking/dogtracking.proto")
public final class DogTrackingGrpc {

  private DogTrackingGrpc() {}

  public static final String SERVICE_NAME = "dogtracking.DogTracking";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.dogtracking.grpc.WearingCollarRequest,
      com.github.dogtracking.grpc.WearingCollarResponse> getWearingCollarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "WearingCollar",
      requestType = com.github.dogtracking.grpc.WearingCollarRequest.class,
      responseType = com.github.dogtracking.grpc.WearingCollarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.dogtracking.grpc.WearingCollarRequest,
      com.github.dogtracking.grpc.WearingCollarResponse> getWearingCollarMethod() {
    io.grpc.MethodDescriptor<com.github.dogtracking.grpc.WearingCollarRequest, com.github.dogtracking.grpc.WearingCollarResponse> getWearingCollarMethod;
    if ((getWearingCollarMethod = DogTrackingGrpc.getWearingCollarMethod) == null) {
      synchronized (DogTrackingGrpc.class) {
        if ((getWearingCollarMethod = DogTrackingGrpc.getWearingCollarMethod) == null) {
          DogTrackingGrpc.getWearingCollarMethod = getWearingCollarMethod =
              io.grpc.MethodDescriptor.<com.github.dogtracking.grpc.WearingCollarRequest, com.github.dogtracking.grpc.WearingCollarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "WearingCollar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.WearingCollarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.WearingCollarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DogTrackingMethodDescriptorSupplier("WearingCollar"))
              .build();
        }
      }
    }
    return getWearingCollarMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.dogtracking.grpc.SafetyZoneRequest,
      com.github.dogtracking.grpc.UpdateLocationResponse> getOutOfBoundsLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OutOfBoundsLocation",
      requestType = com.github.dogtracking.grpc.SafetyZoneRequest.class,
      responseType = com.github.dogtracking.grpc.UpdateLocationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.dogtracking.grpc.SafetyZoneRequest,
      com.github.dogtracking.grpc.UpdateLocationResponse> getOutOfBoundsLocationMethod() {
    io.grpc.MethodDescriptor<com.github.dogtracking.grpc.SafetyZoneRequest, com.github.dogtracking.grpc.UpdateLocationResponse> getOutOfBoundsLocationMethod;
    if ((getOutOfBoundsLocationMethod = DogTrackingGrpc.getOutOfBoundsLocationMethod) == null) {
      synchronized (DogTrackingGrpc.class) {
        if ((getOutOfBoundsLocationMethod = DogTrackingGrpc.getOutOfBoundsLocationMethod) == null) {
          DogTrackingGrpc.getOutOfBoundsLocationMethod = getOutOfBoundsLocationMethod =
              io.grpc.MethodDescriptor.<com.github.dogtracking.grpc.SafetyZoneRequest, com.github.dogtracking.grpc.UpdateLocationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OutOfBoundsLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.SafetyZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.UpdateLocationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DogTrackingMethodDescriptorSupplier("OutOfBoundsLocation"))
              .build();
        }
      }
    }
    return getOutOfBoundsLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.dogtracking.grpc.OwnerLocationRequest,
      com.github.dogtracking.grpc.DogLocationResponse> getFindTheDogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindTheDog",
      requestType = com.github.dogtracking.grpc.OwnerLocationRequest.class,
      responseType = com.github.dogtracking.grpc.DogLocationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.dogtracking.grpc.OwnerLocationRequest,
      com.github.dogtracking.grpc.DogLocationResponse> getFindTheDogMethod() {
    io.grpc.MethodDescriptor<com.github.dogtracking.grpc.OwnerLocationRequest, com.github.dogtracking.grpc.DogLocationResponse> getFindTheDogMethod;
    if ((getFindTheDogMethod = DogTrackingGrpc.getFindTheDogMethod) == null) {
      synchronized (DogTrackingGrpc.class) {
        if ((getFindTheDogMethod = DogTrackingGrpc.getFindTheDogMethod) == null) {
          DogTrackingGrpc.getFindTheDogMethod = getFindTheDogMethod =
              io.grpc.MethodDescriptor.<com.github.dogtracking.grpc.OwnerLocationRequest, com.github.dogtracking.grpc.DogLocationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindTheDog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.OwnerLocationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.dogtracking.grpc.DogLocationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DogTrackingMethodDescriptorSupplier("FindTheDog"))
              .build();
        }
      }
    }
    return getFindTheDogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DogTrackingStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogTrackingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogTrackingStub>() {
        @java.lang.Override
        public DogTrackingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogTrackingStub(channel, callOptions);
        }
      };
    return DogTrackingStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DogTrackingBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogTrackingBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogTrackingBlockingStub>() {
        @java.lang.Override
        public DogTrackingBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogTrackingBlockingStub(channel, callOptions);
        }
      };
    return DogTrackingBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DogTrackingFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DogTrackingFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DogTrackingFutureStub>() {
        @java.lang.Override
        public DogTrackingFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DogTrackingFutureStub(channel, callOptions);
        }
      };
    return DogTrackingFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class DogTrackingImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary Method call - check if the dog is wearing the collar
     * </pre>
     */
    public void wearingCollar(com.github.dogtracking.grpc.WearingCollarRequest request,
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.WearingCollarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getWearingCollarMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - sets the out of safety zone if dog strays stream dogs location
     * streams the dogs location if out of bounds is triggered
     * </pre>
     */
    public void outOfBoundsLocation(com.github.dogtracking.grpc.SafetyZoneRequest request,
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.UpdateLocationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOutOfBoundsLocationMethod(), responseObserver);
    }

    /**
     * <pre>
     *Bi directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.OwnerLocationRequest> findTheDog(
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.DogLocationResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getFindTheDogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getWearingCollarMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.dogtracking.grpc.WearingCollarRequest,
                com.github.dogtracking.grpc.WearingCollarResponse>(
                  this, METHODID_WEARING_COLLAR)))
          .addMethod(
            getOutOfBoundsLocationMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.github.dogtracking.grpc.SafetyZoneRequest,
                com.github.dogtracking.grpc.UpdateLocationResponse>(
                  this, METHODID_OUT_OF_BOUNDS_LOCATION)))
          .addMethod(
            getFindTheDogMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.github.dogtracking.grpc.OwnerLocationRequest,
                com.github.dogtracking.grpc.DogLocationResponse>(
                  this, METHODID_FIND_THE_DOG)))
          .build();
    }
  }

  /**
   */
  public static final class DogTrackingStub extends io.grpc.stub.AbstractAsyncStub<DogTrackingStub> {
    private DogTrackingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogTrackingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogTrackingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Method call - check if the dog is wearing the collar
     * </pre>
     */
    public void wearingCollar(com.github.dogtracking.grpc.WearingCollarRequest request,
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.WearingCollarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getWearingCollarMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - sets the out of safety zone if dog strays stream dogs location
     * streams the dogs location if out of bounds is triggered
     * </pre>
     */
    public void outOfBoundsLocation(com.github.dogtracking.grpc.SafetyZoneRequest request,
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.UpdateLocationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getOutOfBoundsLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Bi directional Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.OwnerLocationRequest> findTheDog(
        io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.DogLocationResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getFindTheDogMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class DogTrackingBlockingStub extends io.grpc.stub.AbstractBlockingStub<DogTrackingBlockingStub> {
    private DogTrackingBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogTrackingBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogTrackingBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Method call - check if the dog is wearing the collar
     * </pre>
     */
    public com.github.dogtracking.grpc.WearingCollarResponse wearingCollar(com.github.dogtracking.grpc.WearingCollarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getWearingCollarMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server Streaming Method call - sets the out of safety zone if dog strays stream dogs location
     * streams the dogs location if out of bounds is triggered
     * </pre>
     */
    public java.util.Iterator<com.github.dogtracking.grpc.UpdateLocationResponse> outOfBoundsLocation(
        com.github.dogtracking.grpc.SafetyZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getOutOfBoundsLocationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DogTrackingFutureStub extends io.grpc.stub.AbstractFutureStub<DogTrackingFutureStub> {
    private DogTrackingFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DogTrackingFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DogTrackingFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary Method call - check if the dog is wearing the collar
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.dogtracking.grpc.WearingCollarResponse> wearingCollar(
        com.github.dogtracking.grpc.WearingCollarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getWearingCollarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_WEARING_COLLAR = 0;
  private static final int METHODID_OUT_OF_BOUNDS_LOCATION = 1;
  private static final int METHODID_FIND_THE_DOG = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DogTrackingImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DogTrackingImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_WEARING_COLLAR:
          serviceImpl.wearingCollar((com.github.dogtracking.grpc.WearingCollarRequest) request,
              (io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.WearingCollarResponse>) responseObserver);
          break;
        case METHODID_OUT_OF_BOUNDS_LOCATION:
          serviceImpl.outOfBoundsLocation((com.github.dogtracking.grpc.SafetyZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.UpdateLocationResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_THE_DOG:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findTheDog(
              (io.grpc.stub.StreamObserver<com.github.dogtracking.grpc.DogLocationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DogTrackingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DogTrackingBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.dogtracking.grpc.Dogtracking.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DogTracking");
    }
  }

  private static final class DogTrackingFileDescriptorSupplier
      extends DogTrackingBaseDescriptorSupplier {
    DogTrackingFileDescriptorSupplier() {}
  }

  private static final class DogTrackingMethodDescriptorSupplier
      extends DogTrackingBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DogTrackingMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DogTrackingGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DogTrackingFileDescriptorSupplier())
              .addMethod(getWearingCollarMethod())
              .addMethod(getOutOfBoundsLocationMethod())
              .addMethod(getFindTheDogMethod())
              .build();
        }
      }
    }
    return result;
  }
}
