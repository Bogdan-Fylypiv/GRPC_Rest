// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MatrixService.proto

package com.example.grpc.server.grpcserver;

/**
 * Protobuf type {@code com.example.grpc.server.grpcserver.AddRequest}
 */
public  final class AddRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.grpc.server.grpcserver.AddRequest)
    AddRequestOrBuilder {
  // Use AddRequest.newBuilder() to construct.
  private AddRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AddRequest() {
    matrix1_ = java.util.Collections.emptyList();
    matrix2_ = java.util.Collections.emptyList();
    size_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private AddRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              matrix1_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            matrix1_.add(input.readInt32());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
              matrix1_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              matrix1_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              matrix2_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            matrix2_.add(input.readInt32());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              matrix2_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              matrix2_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
          case 24: {

            size_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        matrix1_ = java.util.Collections.unmodifiableList(matrix1_);
      }
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        matrix2_ = java.util.Collections.unmodifiableList(matrix2_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.grpc.server.grpcserver.MatrixServiceOuterClass.internal_static_com_example_grpc_server_grpcserver_AddRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.grpc.server.grpcserver.MatrixServiceOuterClass.internal_static_com_example_grpc_server_grpcserver_AddRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.grpc.server.grpcserver.AddRequest.class, com.example.grpc.server.grpcserver.AddRequest.Builder.class);
  }

  private int bitField0_;
  public static final int MATRIX1_FIELD_NUMBER = 1;
  private java.util.List<java.lang.Integer> matrix1_;
  /**
   * <code>repeated int32 matrix1 = 1;</code>
   */
  public java.util.List<java.lang.Integer>
      getMatrix1List() {
    return matrix1_;
  }
  /**
   * <code>repeated int32 matrix1 = 1;</code>
   */
  public int getMatrix1Count() {
    return matrix1_.size();
  }
  /**
   * <code>repeated int32 matrix1 = 1;</code>
   */
  public int getMatrix1(int index) {
    return matrix1_.get(index);
  }
  private int matrix1MemoizedSerializedSize = -1;

  public static final int MATRIX2_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Integer> matrix2_;
  /**
   * <code>repeated int32 matrix2 = 2;</code>
   */
  public java.util.List<java.lang.Integer>
      getMatrix2List() {
    return matrix2_;
  }
  /**
   * <code>repeated int32 matrix2 = 2;</code>
   */
  public int getMatrix2Count() {
    return matrix2_.size();
  }
  /**
   * <code>repeated int32 matrix2 = 2;</code>
   */
  public int getMatrix2(int index) {
    return matrix2_.get(index);
  }
  private int matrix2MemoizedSerializedSize = -1;

  public static final int SIZE_FIELD_NUMBER = 3;
  private int size_;
  /**
   * <code>int32 size = 3;</code>
   */
  public int getSize() {
    return size_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (getMatrix1List().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(matrix1MemoizedSerializedSize);
    }
    for (int i = 0; i < matrix1_.size(); i++) {
      output.writeInt32NoTag(matrix1_.get(i));
    }
    if (getMatrix2List().size() > 0) {
      output.writeUInt32NoTag(18);
      output.writeUInt32NoTag(matrix2MemoizedSerializedSize);
    }
    for (int i = 0; i < matrix2_.size(); i++) {
      output.writeInt32NoTag(matrix2_.get(i));
    }
    if (size_ != 0) {
      output.writeInt32(3, size_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < matrix1_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(matrix1_.get(i));
      }
      size += dataSize;
      if (!getMatrix1List().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      matrix1MemoizedSerializedSize = dataSize;
    }
    {
      int dataSize = 0;
      for (int i = 0; i < matrix2_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(matrix2_.get(i));
      }
      size += dataSize;
      if (!getMatrix2List().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      matrix2MemoizedSerializedSize = dataSize;
    }
    if (size_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, size_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.grpc.server.grpcserver.AddRequest)) {
      return super.equals(obj);
    }
    com.example.grpc.server.grpcserver.AddRequest other = (com.example.grpc.server.grpcserver.AddRequest) obj;

    boolean result = true;
    result = result && getMatrix1List()
        .equals(other.getMatrix1List());
    result = result && getMatrix2List()
        .equals(other.getMatrix2List());
    result = result && (getSize()
        == other.getSize());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMatrix1Count() > 0) {
      hash = (37 * hash) + MATRIX1_FIELD_NUMBER;
      hash = (53 * hash) + getMatrix1List().hashCode();
    }
    if (getMatrix2Count() > 0) {
      hash = (37 * hash) + MATRIX2_FIELD_NUMBER;
      hash = (53 * hash) + getMatrix2List().hashCode();
    }
    hash = (37 * hash) + SIZE_FIELD_NUMBER;
    hash = (53 * hash) + getSize();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.AddRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.grpc.server.grpcserver.AddRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.grpc.server.grpcserver.AddRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.grpc.server.grpcserver.AddRequest)
      com.example.grpc.server.grpcserver.AddRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.grpc.server.grpcserver.MatrixServiceOuterClass.internal_static_com_example_grpc_server_grpcserver_AddRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.grpc.server.grpcserver.MatrixServiceOuterClass.internal_static_com_example_grpc_server_grpcserver_AddRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.grpc.server.grpcserver.AddRequest.class, com.example.grpc.server.grpcserver.AddRequest.Builder.class);
    }

    // Construct using com.example.grpc.server.grpcserver.AddRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      matrix1_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      matrix2_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      size_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.grpc.server.grpcserver.MatrixServiceOuterClass.internal_static_com_example_grpc_server_grpcserver_AddRequest_descriptor;
    }

    public com.example.grpc.server.grpcserver.AddRequest getDefaultInstanceForType() {
      return com.example.grpc.server.grpcserver.AddRequest.getDefaultInstance();
    }

    public com.example.grpc.server.grpcserver.AddRequest build() {
      com.example.grpc.server.grpcserver.AddRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.example.grpc.server.grpcserver.AddRequest buildPartial() {
      com.example.grpc.server.grpcserver.AddRequest result = new com.example.grpc.server.grpcserver.AddRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        matrix1_ = java.util.Collections.unmodifiableList(matrix1_);
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.matrix1_ = matrix1_;
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        matrix2_ = java.util.Collections.unmodifiableList(matrix2_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.matrix2_ = matrix2_;
      result.size_ = size_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.grpc.server.grpcserver.AddRequest) {
        return mergeFrom((com.example.grpc.server.grpcserver.AddRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.grpc.server.grpcserver.AddRequest other) {
      if (other == com.example.grpc.server.grpcserver.AddRequest.getDefaultInstance()) return this;
      if (!other.matrix1_.isEmpty()) {
        if (matrix1_.isEmpty()) {
          matrix1_ = other.matrix1_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensureMatrix1IsMutable();
          matrix1_.addAll(other.matrix1_);
        }
        onChanged();
      }
      if (!other.matrix2_.isEmpty()) {
        if (matrix2_.isEmpty()) {
          matrix2_ = other.matrix2_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureMatrix2IsMutable();
          matrix2_.addAll(other.matrix2_);
        }
        onChanged();
      }
      if (other.getSize() != 0) {
        setSize(other.getSize());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.grpc.server.grpcserver.AddRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.grpc.server.grpcserver.AddRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<java.lang.Integer> matrix1_ = java.util.Collections.emptyList();
    private void ensureMatrix1IsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        matrix1_ = new java.util.ArrayList<java.lang.Integer>(matrix1_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getMatrix1List() {
      return java.util.Collections.unmodifiableList(matrix1_);
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public int getMatrix1Count() {
      return matrix1_.size();
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public int getMatrix1(int index) {
      return matrix1_.get(index);
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public Builder setMatrix1(
        int index, int value) {
      ensureMatrix1IsMutable();
      matrix1_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public Builder addMatrix1(int value) {
      ensureMatrix1IsMutable();
      matrix1_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public Builder addAllMatrix1(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureMatrix1IsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, matrix1_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix1 = 1;</code>
     */
    public Builder clearMatrix1() {
      matrix1_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> matrix2_ = java.util.Collections.emptyList();
    private void ensureMatrix2IsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        matrix2_ = new java.util.ArrayList<java.lang.Integer>(matrix2_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getMatrix2List() {
      return java.util.Collections.unmodifiableList(matrix2_);
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public int getMatrix2Count() {
      return matrix2_.size();
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public int getMatrix2(int index) {
      return matrix2_.get(index);
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public Builder setMatrix2(
        int index, int value) {
      ensureMatrix2IsMutable();
      matrix2_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public Builder addMatrix2(int value) {
      ensureMatrix2IsMutable();
      matrix2_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public Builder addAllMatrix2(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureMatrix2IsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, matrix2_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 matrix2 = 2;</code>
     */
    public Builder clearMatrix2() {
      matrix2_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    private int size_ ;
    /**
     * <code>int32 size = 3;</code>
     */
    public int getSize() {
      return size_;
    }
    /**
     * <code>int32 size = 3;</code>
     */
    public Builder setSize(int value) {
      
      size_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 size = 3;</code>
     */
    public Builder clearSize() {
      
      size_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.example.grpc.server.grpcserver.AddRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.grpc.server.grpcserver.AddRequest)
  private static final com.example.grpc.server.grpcserver.AddRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.grpc.server.grpcserver.AddRequest();
  }

  public static com.example.grpc.server.grpcserver.AddRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AddRequest>
      PARSER = new com.google.protobuf.AbstractParser<AddRequest>() {
    public AddRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new AddRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AddRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AddRequest> getParserForType() {
    return PARSER;
  }

  public com.example.grpc.server.grpcserver.AddRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

