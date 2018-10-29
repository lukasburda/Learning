package org.xstefank.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({GitHubAPI.class})
public class GitHubAPITest {

    @Before
    public void before() throws Exception {
        PowerMockito.spy(GitHubAPI.class);
        PowerMockito.doReturn(null).when(GitHubAPI.class, "readToken");
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateCommitStatusNullParameters() {
        GitHubAPI.updateCommitStatus(null, null, null, null, null, null);
    }

    @Test(expected = NullPointerException.class)
    public void testGetJsonWithCommitsNullParameter() {
        GitHubAPI.getJsonWithCommits(null);
    }
}
