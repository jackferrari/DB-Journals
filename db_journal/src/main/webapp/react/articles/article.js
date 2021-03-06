import ArticleList from "./article-content/article-list";
import ArticleFormEditor from "./article-content/article-form-editor";
import AuthorList from "./article-content/article-author-list";
import EditorList from "./article-content/article-editor-list";
import JournalList from "./article-content/article-journal-list";
const {HashRouter, Route} = window.ReactRouterDOM;
const App = () => {
    return (
        <div className="container-fluid">
            <HashRouter>
                <Route path={["/articles", "/"]} exact={true}>
                    <ArticleList/>
                </Route>
                <Route path="/articles/:id" exact={true}>
                    <ArticleFormEditor/>
                </Route>
                <Route path={["/articles/:id/authors"]} exact={true}>
                    <AuthorList/>
                </Route>
                <Route path={["/articles/:id/editors"]} exact={true}>
                    <EditorList/>
                </Route>
                <Route path={["/articles/:id/journals"]} exact={true}>
                    <JournalList/>
                </Route>
            </HashRouter>
        </div>
    );
}

export default App;
