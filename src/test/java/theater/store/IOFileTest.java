package theater.store;

import org.junit.jupiter.api.Test;
import theater.Date;
import theater.Member;
import theater.lists.MemberList;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class IOFileTest {
    private IOFile ioFile = new IOFile();

    @Test
    void should_be_read_and_write_memberList_successfully() throws Exception {
        MemberList memberListBeforeWrite = new MemberList();

        Member member = generateTestMember();
        Member member2 = generateTestMember();
        Member member3 = generateTestMember();
        memberListBeforeWrite.register(member);

        ioFile.writeMembers(memberListBeforeWrite);

        MemberList memberListAfterWrite = ioFile.readMember();
        assertThat(memberListBeforeWrite.length()).isEqualTo(memberListAfterWrite.length());
        assertThat(memberListBeforeWrite.getMember(1).getFirstName())
                .isEqualTo(memberListAfterWrite.getMember(1).getFirstName());
    }

    private Member generateTestMember() throws Exception {
        return new Member(randomString(), randomString(),
                randomString(), 1, new Date(1, 1, 1379), 9356207222L, randomString());
    }

    private String randomString() {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}