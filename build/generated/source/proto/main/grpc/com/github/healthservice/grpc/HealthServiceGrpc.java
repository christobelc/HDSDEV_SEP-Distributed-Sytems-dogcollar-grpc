package com.github.healthservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.37.0)",
    comments = "Source: healthservice/healthservice.proto")
public final class HealthServiceGrpc {

  private HealthServiceGrpc() {}

  public static final String SERVICE_NAME = "healthservice.HealthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.github.healthservice.grpc.TemperatureRequest,
      com.github.healthservice.grpc.TemperatureResponse> getCheckTemperatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkTemperature",
      requestType = com.github.healthservice.grpc.TemperatureRequest.class,
      responseType = com.github.healthservice.grpc.TemperatureResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.github.healthservice.grpc.TemperatureRequest,
      com.github.healthservice.grpc.TemperatureResponse> getCheckTemperatureMethod() {
    io.grpc.MethodDescriptor<com.github.healthservice.grpc.TemperatureRequest, com.github.healthservice.grpc.TemperatureResponse> getCheckTemperatureMethod;
    if ((getCheckTemperatureMethod = HealthServiceGrpc.getCheckTemperatureMethod) == null) {
      synchronized (HealthServiceGrpc.class) {
        if ((getCheckTemperatureMethod = HealthServiceGrpc.getCheckTemperatureMethod) == null) {
          HealthServiceGrpc.getCheckTemperatureMethod = getCheckTemperatureMethod =
              io.grpc.MethodDescriptor.<com.github.healthservice.grpc.TemperatureRequest, com.github.healthservice.grpc.TemperatureResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkTemperature"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.TemperatureRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.TemperatureResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HealthServiceMethodDescriptorSupplier("checkTemperature"))
              .build();
        }
      }
    }
    return getCheckTemperatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.healthservice.grpc.PedometerRequest,
      com.github.healthservice.grpc.PedometerResponse> getStepCounterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stepCounter",
      requestType = com.github.healthservice.grpc.PedometerRequest.class,
      responseType = com.github.healthservice.grpc.PedometerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.healthservice.grpc.PedometerRequest,
      com.github.healthservice.grpc.PedometerResponse> getStepCounterMethod() {
    io.grpc.MethodDescriptor<com.github.healthservice.grpc.PedometerRequest, com.github.healthservice.grpc.PedometerResponse> getStepCounterMethod;
    if ((getStepCounterMethod = HealthServiceGrpc.getStepCounterMethod) == null) {
      synchronized (HealthServiceGrpc.class) {
        if ((getStepCounterMethod = HealthServiceGrpc.getStepCounterMethod) == null) {
          HealthServiceGrpc.getStepCounterMethod = getStepCounterMethod =
              io.grpc.MethodDescriptor.<com.github.healthservice.grpc.PedometerRequest, com.github.healthservice.grpc.PedometerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "stepCounter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.PedometerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.PedometerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HealthServiceMethodDescriptorSupplier("stepCounter"))
              .build();
        }
      }
    }
    return getStepCounterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.github.healthservice.grpc.HeartBeatSensorRequest,
      com.github.healthservice.grpc.HeartBeatSensorResponse> getBpmCounterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "bpmCounter",
      requestType = com.github.healthservice.grpc.HeartBeatSensorRequest.class,
      responseType = com.github.healthservice.grpc.HeartBeatSensorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.github.healthservice.grpc.HeartBeatSensorRequest,
      com.github.healthservice.grpc.HeartBeatSensorResponse> getBpmCounterMethod() {
    io.grpc.MethodDescriptor<com.github.healthservice.grpc.HeartBeatSensorRequest, com.github.healthservice.grpc.HeartBeatSensorResponse> getBpmCounterMethod;
    if ((getBpmCounterMethod = HealthServiceGrpc.getBpmCounterMethod) == null) {
      synchronized (HealthServiceGrpc.class) {
        if ((getBpmCounterMethod = HealthServiceGrpc.getBpmCounterMethod) == null) {
          HealthServiceGrpc.getBpmCounterMethod = getBpmCounterMethod =
              io.grpc.MethodDescriptor.<com.github.healthservice.grpc.HeartBeatSensorRequest, com.github.healthservice.grpc.HeartBeatSensorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "bpmCounter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.HeartBeatSensorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.github.healthservice.grpc.HeartBeatSensorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HealthServiceMethodDescriptorSupplier("bpmCounter"))
              .build();
        }
      }
    }
    return getBpmCounterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthServiceStub>() {
        @java.lang.Override
        public HealthServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthServiceStub(channel, callOptions);
        }
      };
    return HealthServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthServiceBlockingStub>() {
        @java.lang.Override
        public HealthServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthServiceBlockingStub(channel, callOptions);
        }
      };
    return HealthServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthServiceFutureStub>() {
        @java.lang.Override
        public HealthServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthServiceFutureStub(channel, callOptions);
        }
      };
    return HealthServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HealthServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary method call
     * </pre>
     */
    public void checkTemperature(com.github.healthservice.grpc.TemperatureRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.TemperatureResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckTemperatureMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - Step counter for the dog using the inbuilt pedometer
     * </pre>
     */
    public void stepCounter(com.github.healthservice.grpc.PedometerRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.PedometerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStepCounterMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - Heartbeat sensor checks the dogs beats per minute
     * </pre>
     */
    public void bpmCounter(com.github.healthservice.grpc.HeartBeatSensorRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.HeartBeatSensorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBpmCounterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckTemperatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.github.healthservice.grpc.TemperatureRequest,
                com.github.healthservice.grpc.TemperatureResponse>(
                  this, METHODID_CHECK_TEMPERATURE)))
          .addMethod(
            getStepCounterMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.github.healthservice.grpc.PedometerRequest,
                com.github.healthservice.grpc.PedometerResponse>(
                  this, METHODID_STEP_COUNTER)))
          .addMethod(
            getBpmCounterMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.github.healthservice.grpc.HeartBeatSensorRequest,
                com.github.healthservice.grpc.HeartBeatSensorResponse>(
                  this, METHODID_BPM_COUNTER)))
          .build();
    }
  }

  /**
   */
  public static final class HealthServiceStub extends io.grpc.stub.AbstractAsyncStub<HealthServiceStub> {
    private HealthServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary method call
     * </pre>
     */
    public void checkTemperature(com.github.healthservice.grpc.TemperatureRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.TemperatureResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckTemperatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - Step counter for the dog using the inbuilt pedometer
     * </pre>
     */
    public void stepCounter(com.github.healthservice.grpc.PedometerRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.PedometerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStepCounterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server Streaming Method call - Heartbeat sensor checks the dogs beats per minute
     * </pre>
     */
    public void bpmCounter(com.github.healthservice.grpc.HeartBeatSensorRequest request,
        io.grpc.stub.StreamObserver<com.github.healthservice.grpc.HeartBeatSensorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getBpmCounterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class HealthServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HealthServiceBlockingStub> {
    private HealthServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary method call
     * </pre>
     */
    public com.github.healthservice.grpc.TemperatureResponse checkTemperature(com.github.healthservice.grpc.TemperatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckTemperatureMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server Streaming Method call - Step counter for the dog using the inbuilt pedometer
     * </pre>
     */
    public java.util.Iterator<com.github.healthservice.grpc.PedometerResponse> stepCounter(
        com.github.healthservice.grpc.PedometerRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStepCounterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server Streaming Method call - Heartbeat sensor checks the dogs beats per minute
     * </pre>
     */
    public java.util.Iterator<com.github.healthservice.grpc.HeartBeatSensorResponse> bpmCounter(
        com.github.healthservice.grpc.HeartBeatSensorRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getBpmCounterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class HealthServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HealthServiceFutureStub> {
    private HealthServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary method call
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.healthservice.grpc.TemperatureResponse> checkTemperature(
        com.github.healthservice.grpc.TemperatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckTemperatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_TEMPERATURE = 0;
  private static final int METHODID_STEP_COUNTER = 1;
  private static final int METHODID_BPM_COUNTER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_TEMPERATURE:
          serviceImpl.checkTemperature((com.github.healthservice.grpc.TemperatureRequest) request,
              (io.grpc.stub.StreamObserver<com.github.healthservice.grpc.TemperatureResponse>) responseObserver);
          break;
        case METHODID_STEP_COUNTER:
          serviceImpl.stepCounter((com.github.healthservice.grpc.PedometerRequest) request,
              (io.grpc.stub.StreamObserver<com.github.healthservice.grpc.PedometerResponse>) responseObserver);
          break;
        case METHODID_BPM_COUNTER:
          serviceImpl.bpmCounter((com.github.healthservice.grpc.HeartBeatSensorRequest) request,
              (io.grpc.stub.StreamObserver<com.github.healthservice.grpc.HeartBeatSensorResponse>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.healthservice.grpc.Healthservice.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthService");
    }
  }

  private static final class HealthServiceFileDescriptorSupplier
      extends HealthServiceBaseDescriptorSupplier {
    HealthServiceFileDescriptorSupplier() {}
  }

  private static final class HealthServiceMethodDescriptorSupplier
      extends HealthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HealthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthServiceFileDescriptorSupplier())
              .addMethod(getCheckTemperatureMethod())
              .addMethod(getStepCounterMethod())
              .addMethod(getBpmCounterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
