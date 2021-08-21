package centralservice;

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
public final class CentralServiceGrpc {

  private CentralServiceGrpc() {}

  public static final String SERVICE_NAME = "centralservice.CentralService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<centralservice.Contract.Track,
      centralservice.Contract.Tariff> getPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "payment",
      requestType = centralservice.Contract.Track.class,
      responseType = centralservice.Contract.Tariff.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<centralservice.Contract.Track,
      centralservice.Contract.Tariff> getPaymentMethod() {
    io.grpc.MethodDescriptor<centralservice.Contract.Track, centralservice.Contract.Tariff> getPaymentMethod;
    if ((getPaymentMethod = CentralServiceGrpc.getPaymentMethod) == null) {
      synchronized (CentralServiceGrpc.class) {
        if ((getPaymentMethod = CentralServiceGrpc.getPaymentMethod) == null) {
          CentralServiceGrpc.getPaymentMethod = getPaymentMethod =
              io.grpc.MethodDescriptor.<centralservice.Contract.Track, centralservice.Contract.Tariff>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "payment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  centralservice.Contract.Track.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  centralservice.Contract.Tariff.getDefaultInstance()))
              .setSchemaDescriptor(new CentralServiceMethodDescriptorSupplier("payment"))
              .build();
        }
      }
    }
    return getPaymentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CentralServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceStub>() {
        @java.lang.Override
        public CentralServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceStub(channel, callOptions);
        }
      };
    return CentralServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CentralServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceBlockingStub>() {
        @java.lang.Override
        public CentralServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceBlockingStub(channel, callOptions);
        }
      };
    return CentralServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CentralServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CentralServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CentralServiceFutureStub>() {
        @java.lang.Override
        public CentralServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CentralServiceFutureStub(channel, callOptions);
        }
      };
    return CentralServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CentralServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void payment(centralservice.Contract.Track request,
        io.grpc.stub.StreamObserver<centralservice.Contract.Tariff> responseObserver) {
      asyncUnimplementedUnaryCall(getPaymentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPaymentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                centralservice.Contract.Track,
                centralservice.Contract.Tariff>(
                  this, METHODID_PAYMENT)))
          .build();
    }
  }

  /**
   */
  public static final class CentralServiceStub extends io.grpc.stub.AbstractAsyncStub<CentralServiceStub> {
    private CentralServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceStub(channel, callOptions);
    }

    /**
     */
    public void payment(centralservice.Contract.Track request,
        io.grpc.stub.StreamObserver<centralservice.Contract.Tariff> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPaymentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CentralServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CentralServiceBlockingStub> {
    private CentralServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public centralservice.Contract.Tariff payment(centralservice.Contract.Track request) {
      return blockingUnaryCall(
          getChannel(), getPaymentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CentralServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CentralServiceFutureStub> {
    private CentralServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CentralServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CentralServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<centralservice.Contract.Tariff> payment(
        centralservice.Contract.Track request) {
      return futureUnaryCall(
          getChannel().newCall(getPaymentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PAYMENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CentralServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CentralServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PAYMENT:
          serviceImpl.payment((centralservice.Contract.Track) request,
              (io.grpc.stub.StreamObserver<centralservice.Contract.Tariff>) responseObserver);
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

  private static abstract class CentralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CentralServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return centralservice.Contract.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CentralService");
    }
  }

  private static final class CentralServiceFileDescriptorSupplier
      extends CentralServiceBaseDescriptorSupplier {
    CentralServiceFileDescriptorSupplier() {}
  }

  private static final class CentralServiceMethodDescriptorSupplier
      extends CentralServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CentralServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CentralServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CentralServiceFileDescriptorSupplier())
              .addMethod(getPaymentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
