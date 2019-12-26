## IndexReader   
```text
IndexReader相关
IndexReaderContext -- CompositeReaderContext, LeafReaderContext
IndexReader 
LeafReader -- CodecReader, SegmentReader 等   SegmentCoreReaders !!!
CompositeReader -- BaseCompositeReader, DirectoryReader, StandardDirectoryReader 等


索引文件对应的实体类:
SegmentInfos  SegmentCommitInfo  SegmentInfo 
FieldInfos FieldInfo



Fields  MultiFields 
MappedMultiFields


DocumentWriter相关 
    DocumentsWriterDeleteQueue
    DocumentsWriterFlushControl
    DocumentsWriterFlushQueue
    DocumentsWriter
    DocumentsWriterPerThread
    DocumentsWriterPerThreadPool
    DocumentsWriterStallControl

IndexDeletionPolicy相关:
    IndexDeletionPolicy 
    KeepOnlyLastCommitDeletionPolicy
    NoDeletionPolicy
    PersistentSnapshotDeletionPolicy
    SnapshotDeletionPolicy

MergePolicy相关: 
    MergePolicy  NoMergePolicy  OneMergeWrappingMergePolicy  SoftDeletesRetentionMergePolicy
    TieredMergePolicy  UpgradeIndexMergePolicy  FilterMergePolicy
    LogByteSizeMergePolicy  LogDocMergePolicy  LogMergePolicy

MergeScheduler相关: 
    MergeScheduler  ConcurrentMergeScheduler  NoMergeScheduler  SerialMergeScheduler


```
