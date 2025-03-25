/**
 *
 * 5. API Rate Limiting (Top Senior -> Lead)
 * What is it good for?
 *   Prevent overloading the server, esp. during spikes in traffic
 * How might we implement it?
 *   Spring cloud gateway, Bucket4j, Token Bucket Algorithm, Sliding Windows
 * Note: the practical exercise doesn't need to compile, but we do want to see what kind of strategy the candidate uses
 * for implementing rate limiting.  It has some dependencies on spring libraries, which won't
 * be practical in a short interview
 * Imagine we have an API that we need to rate limit to 2 requests per second, with a maximum of 120 per minute.
 * Try implementing it.
 * import org.springframework.http.HttpStatus;
 * import org.springframework.http.ResponseEntity;
 * import org.springframework.stereotype.Controller;
 * import org.springframework.web.bind.annotation.PostMapping;
 * import org.springframework.web.bind.annotation.RequestParam;
 * @Controller
 * public class FooService {
 *     private boolean allow() {
 *         // Implement rate limiting logic here
 *         return true;
 *     }
 *     @PostMapping("/api/v1/foo")
 *     public ResponseEntity<String> foo(@RequestParam String bar) {
 *         if (!allow()) {
 *             return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body("Rate limit exceeded");
 *         }
 *         return ResponseEntity.ok("Hello, " + bar);
 *     }
 * }
 */
public class RateLimiting {

}
