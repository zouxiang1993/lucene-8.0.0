```text
DISI:  
DocIdSet  DocIdSetIterator
BlockMaxDISI  ConjunctionDISI   ImpactsDISI  FilteredDocIdSetIterator
DisiPriorityQueue  DisiWrapper  DisjunctionDISIApproximation

Query子类:  
MultiTermQuery  NGramPhraseQuery  NormsFieldExistsQuery  PhraseQuery  PrefixQuery
RegexpQuery  BoostQuery  ConstantScoreQuery  DisjunctionMaxQuery  DocValuesFieldExistsQuery
FuzzyQuery  IndexOrDocValuesQuery  MatchAllDocsQuery  MatchNoDocsQuery  MultiPhraseQuery
PhraseQueue  PointInSetQuery  PointRangeQuery  SynonymQuery  TermInSetQuery
TermQuery  TermRangeQuery  WildcardQuery  AutomatonQuery  BlendedTermQuery  BooleanQuery

Weight子类: 
BooleanWeight  ConstantScoreWeight  FilterWeight  PhraseWeight

Scorer子类: 
BlockMaxConjunctionScorer
Boolean2ScorerSupplier
BooleanScorer
BulkScorer
DisjunctionMaxScorer
DisjunctionScorer
DisjunctionSumScorer
ConjunctionScorer
FilterScorer
LeafSimScorer
MinShouldMatchSumScorer
PhraseScorer
ConstantScoreScorer
ReqExclBulkScorer
ReqExclScorer
ReqOptSumScorer
ScoreCachingWrappingScorer
Scorer
ScorerSupplier
TermScorer
WANDScorer

Collector子类: 
TimeLimitingCollector
TopDocsCollector
TopFieldCollector
TopScoreDocCollector
TotalHitCountCollector
SimpleCollector
CachingCollector
FilterCollector
FilterLeafCollector
LeafCollector
PositiveScoresOnlyCollector

MultiCollector
CollectorManager
MultiCollectorManager

Cache相关: 
QueryCache
LRUQueryCache
QueryCachingPolicy
UsageTrackingQueryCachingPolicy

Rescorer子类: 
SortRescorer
QueryRescorer
```