package roadservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.28.1)",
    comments = "Source: contract.proto")
public final class RoadServiceGrpc {

  private RoadServiceGrpc() {}

  public static final String SERVICE_NAME = "roadservice.RoadService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<roadservice.Contract.EntryPoint,
      roadservice.Contract.Void> getEnterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Enter",
      requestType = roadservice.Contract.EntryPoint.class,
      responseType = roadservice.Contract.Void.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<roadservice.Contract.EntryPoint,
      roadservice.Contract.Void> getEnterMethod() {
    io.grpc.MethodDescriptor<roadservice.Contract.EntryPoint, roadservice.Contract.Void> getEnterMethod;
    if ((getEnterMethod = RoadServiceGrpc.getEnterMethod) == null) {
      synchronized (RoadServiceGrpc.class) {
        if ((getEnterMethod = RoadServiceGrpc.getEnterMethod) == null) {
          RoadServiceGrpc.getEnterMethod = getEnterMethod =
              io.grpc.MethodDescriptor.<roadservice.Contract.EntryPoint, roadservice.Contract.Void>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Enter"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.EntryPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.Void.getDefaultInstance()))
              .setSchemaDescriptor(new RoadServiceMethodDescriptorSupplier("Enter"))
              .build();
        }
      }
    }
    return getEnterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<roadservice.Contract.WarnMsg,
      roadservice.Contract.WarnMsg> getEnableWarningsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableWarnings",
      requestType = roadservice.Contract.WarnMsg.class,
      responseType = roadservice.Contract.WarnMsg.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<roadservice.Contract.WarnMsg,
      roadservice.Contract.WarnMsg> getEnableWarningsMethod() {
    io.grpc.MethodDescriptor<roadservice.Contract.WarnMsg, roadservice.Contract.WarnMsg> getEnableWarningsMethod;
    if ((getEnableWarningsMethod = RoadServiceGrpc.getEnableWarningsMethod) == null) {
      synchronized (RoadServiceGrpc.class) {
        if ((getEnableWarningsMethod = RoadServiceGrpc.getEnableWarningsMethod) == null) {
          RoadServiceGrpc.getEnableWarningsMethod = getEnableWarningsMethod =
              io.grpc.MethodDescriptor.<roadservice.Contract.WarnMsg, roadservice.Contract.WarnMsg>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableWarnings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.WarnMsg.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.WarnMsg.getDefaultInstance()))
              .setSchemaDescriptor(new RoadServiceMethodDescriptorSupplier("EnableWarnings"))
              .build();
        }
      }
    }
    return getEnableWarningsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<roadservice.Contract.FinalPoint,
      roadservice.Contract.Payment> getLeaveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Leave",
      requestType = roadservice.Contract.FinalPoint.class,
      responseType = roadservice.Contract.Payment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<roadservice.Contract.FinalPoint,
      roadservice.Contract.Payment> getLeaveMethod() {
    io.grpc.MethodDescriptor<roadservice.Contract.FinalPoint, roadservice.Contract.Payment> getLeaveMethod;
    if ((getLeaveMethod = RoadServiceGrpc.getLeaveMethod) == null) {
      synchronized (RoadServiceGrpc.class) {
        if ((getLeaveMethod = RoadServiceGrpc.getLeaveMethod) == null) {
          RoadServiceGrpc.getLeaveMethod = getLeaveMethod =
              io.grpc.MethodDescriptor.<roadservice.Contract.FinalPoint, roadservice.Contract.Payment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Leave"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.FinalPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  roadservice.Contract.Payment.getDefaultInstance()))
              .setSchemaDescriptor(new RoadServiceMethodDescriptorSupplier("Leave"))
              .build();
        }
      }
    }
    return getLeaveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RoadServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoadServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoadServiceStub>() {
        @java.lang.Override
        public RoadServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoadServiceStub(channel, callOptions);
        }
      };
    return RoadServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RoadServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoadServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoadServiceBlockingStub>() {
        @java.lang.Override
        public RoadServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoadServiceBlockingStub(channel, callOptions);
        }
      };
    return RoadServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RoadServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RoadServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RoadServiceFutureStub>() {
        @java.lang.Override
        public RoadServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RoadServiceFutureStub(channel, callOptions);
        }
      };
    return RoadServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RoadServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Enter the road
     * </pre>
     */
    public void enter(roadservice.Contract.EntryPoint request,
        io.grpc.stub.StreamObserver<roadservice.Contract.Void> responseObserver) {
      asyncUnimplementedUnaryCall(getEnterMethod(), responseObserver);
    }

    /**
     * <pre>
     * Register to send/receive warnings
     * </pre>
     */
    public io.grpc.stub.StreamObserver<roadservice.Contract.WarnMsg> enableWarnings(
        io.grpc.stub.StreamObserver<roadservice.Contract.WarnMsg> responseObserver) {
      return asyncUnimplementedStreamingCall(getEnableWarningsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Leave the road
     * </pre>
     */
    public void leave(roadservice.Contract.FinalPoint request,
        io.grpc.stub.StreamObserver<roadservice.Contract.Payment> responseObserver) {
      asyncUnimplementedUnaryCall(getLeaveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnterMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                roadservice.Contract.EntryPoint,
                roadservice.Contract.Void>(
                  this, METHODID_ENTER)))
          .addMethod(
            getEnableWarningsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                roadservice.Contract.WarnMsg,
                roadservice.Contract.WarnMsg>(
                  this, METHODID_ENABLE_WARNINGS)))
          .addMethod(
            getLeaveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                roadservice.Contract.FinalPoint,
                roadservice.Contract.Payment>(
                  this, METHODID_LEAVE)))
          .build();
    }
  }

  /**
   */
  public static final class RoadServiceStub extends io.grpc.stub.AbstractAsyncStub<RoadServiceStub> {
    private RoadServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoadServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoadServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enter the road
     * </pre>
     */
    public void enter(roadservice.Contract.EntryPoint request,
        io.grpc.stub.StreamObserver<roadservice.Contract.Void> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Register to send/receive warnings
     * </pre>
     */
    public io.grpc.stub.StreamObserver<roadservice.Contract.WarnMsg> enableWarnings(
        io.grpc.stub.StreamObserver<roadservice.Contract.WarnMsg> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getEnableWarningsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Leave the road
     * </pre>
     */
    public void leave(roadservice.Contract.FinalPoint request,
        io.grpc.stub.StreamObserver<roadservice.Contract.Payment> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RoadServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RoadServiceBlockingStub> {
    private RoadServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoadServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoadServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enter the road
     * </pre>
     */
    public roadservice.Contract.Void enter(roadservice.Contract.EntryPoint request) {
      return blockingUnaryCall(
          getChannel(), getEnterMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Leave the road
     * </pre>
     */
    public roadservice.Contract.Payment leave(roadservice.Contract.FinalPoint request) {
      return blockingUnaryCall(
          getChannel(), getLeaveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RoadServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RoadServiceFutureStub> {
    private RoadServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RoadServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RoadServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enter the road
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<roadservice.Contract.Void> enter(
        roadservice.Contract.EntryPoint request) {
      return futureUnaryCall(
          getChannel().newCall(getEnterMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Leave the road
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<roadservice.Contract.Payment> leave(
        roadservice.Contract.FinalPoint request) {
      return futureUnaryCall(
          getChannel().newCall(getLeaveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENTER = 0;
  private static final int METHODID_LEAVE = 1;
  private static final int METHODID_ENABLE_WARNINGS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RoadServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RoadServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENTER:
          serviceImpl.enter((roadservice.Contract.EntryPoint) request,
              (io.grpc.stub.StreamObserver<roadservice.Contract.Void>) responseObserver);
          break;
        case METHODID_LEAVE:
          serviceImpl.leave((roadservice.Contract.FinalPoint) request,
              (io.grpc.stub.StreamObserver<roadservice.Contract.Payment>) responseObserver);
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
        case METHODID_ENABLE_WARNINGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.enableWarnings(
              (io.grpc.stub.StreamObserver<roadservice.Contract.WarnMsg>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class RoadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RoadServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return roadservice.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RoadService");
    }
  }

  private static final class RoadServiceFileDescriptorSupplier
      extends RoadServiceBaseDescriptorSupplier {
    RoadServiceFileDescriptorSupplier() {}
  }

  private static final class RoadServiceMethodDescriptorSupplier
      extends RoadServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RoadServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RoadServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RoadServiceFileDescriptorSupplier())
              .addMethod(getEnterMethod())
              .addMethod(getEnableWarningsMethod())
              .addMethod(getLeaveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
