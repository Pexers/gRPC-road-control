import roadservice.Contract.WarnMsg;
import io.grpc.stub.StreamObserver;

public class WarningStreamObserver implements StreamObserver<WarnMsg> {

    @Override
    public void onNext(WarnMsg warnMsg) {
        System.out.println(warnMsg.getMessage());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Error on call:" + throwable.getMessage());
    }

    @Override
    public void onCompleted() {
        System.out.println("Completed all operations");
    }

}
