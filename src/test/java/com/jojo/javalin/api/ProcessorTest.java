// package com.jojo.javalin.api;
//
// import java.io.File;
// import java.io.PrintWriter;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;
// import java.util.Set;
//
// import javax.tools.JavaFileObject;
// import javax.tools.JavaFileObject.Kind;
// import javax.tools.StandardLocation;
// import javax.tools.ToolProvider;
//
// import org.junit.jupiter.api.Test;
//
// import io.avaje.http.generator.client.ClientProcessor;
// import io.avaje.http.generator.helidon.HelidonProcessor;
// import io.avaje.inject.generator.Processor;
//
// class ProcessorTest {
//
//  @Test
//  public void runAnnoationProcessor() throws Exception {
//    final var source = Paths.get("src").toAbsolutePath().toString();
//
//    final var files = getSourceFiles(source);
//
//    final var compiler = ToolProvider.getSystemJavaCompiler();
//
//    final var task =
//        compiler.getTask(
//            new PrintWriter(System.out),
//            null,
//            null,
//            List.of("--enable-preview", "--release=19"),
//            null,
//            files);
//    task.setProcessors(List.of(new HelidonProcessor(), new ClientProcessor(), new Processor()));
//
//    task.call();
//    Files.walk(Paths.get("com").toAbsolutePath())
//        .sorted(Comparator.reverseOrder())
//        .map(Path::toFile)
//        .forEach(File::delete);
//  }
//
//  private Iterable<JavaFileObject> getSourceFiles(String source) throws Exception {
//    final var compiler = ToolProvider.getSystemJavaCompiler();
//    final var files = compiler.getStandardFileManager(null, null, null);
//
//    files.setLocation(StandardLocation.SOURCE_PATH, List.of(new File(source)));
//
//    final Set<Kind> fileKinds = Collections.singleton(Kind.SOURCE);
//    return files.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);
//  }
// }
