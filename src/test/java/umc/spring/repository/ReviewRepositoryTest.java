package umc.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@SpringBootTest
@Transactional
class ReviewRepositoryTest {


    @Autowired ReviewRepository reviewRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired StoreRepository storeRepository;
    @Autowired RegionRepository regionRepository;

    @PersistenceContext
    EntityManager em;
    @Test
    public void testMember() {
        String test = "test";
        Region region1 = new Region(test);
        Member member1 = new Member(test, test, test);
        Store store1 = new Store(test, test, 10.0F, region1);
        Review review1 = new Review(test, 5.0F, test, store1, member1);

        memberRepository.save(member1);
        storeRepository.save(store1);
        reviewRepository.save(review1);
        regionRepository.save(region1);

        String test1 = "test1";

        Member member2 = new Member(test1, test1, test1);
        Review review2 = new Review(test1, 5.0F, test1, store1, member2);

        memberRepository.save(member2);
        reviewRepository.save(review2);

//        em.flush();
//        em.clear();
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<Review> pages = reviewRepository.findAllByStore(store1, pageRequest);
        for (Review pageReview : pages) {
            System.out.println("pageReview1 = " + pageReview);
        }
        Page<Review> nextPage = reviewRepository.findAllByStore(store1, pages.nextPageable());

        for (Review pageReview : nextPage) {
            System.out.println("pageReview2 = " + pageReview);
        }
    }
}