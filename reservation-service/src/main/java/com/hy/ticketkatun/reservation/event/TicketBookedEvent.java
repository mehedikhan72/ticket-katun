/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.hy.ticketkatun.reservation.event;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TicketBookedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1206920301027941778L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TicketBookedEvent\",\"namespace\":\"com.hy.ticketkatun.reservation.event\",\"fields\":[{\"name\":\"trainName\",\"type\":\"string\"},{\"name\":\"seatNumber\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TicketBookedEvent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TicketBookedEvent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TicketBookedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TicketBookedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TicketBookedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TicketBookedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TicketBookedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TicketBookedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TicketBookedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence trainName;
  private java.lang.CharSequence seatNumber;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TicketBookedEvent() {}

  /**
   * All-args constructor.
   * @param trainName The new value for trainName
   * @param seatNumber The new value for seatNumber
   */
  public TicketBookedEvent(java.lang.CharSequence trainName, java.lang.CharSequence seatNumber) {
    this.trainName = trainName;
    this.seatNumber = seatNumber;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return trainName;
    case 1: return seatNumber;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: trainName = (java.lang.CharSequence)value$; break;
    case 1: seatNumber = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'trainName' field.
   * @return The value of the 'trainName' field.
   */
  public java.lang.CharSequence getTrainName() {
    return trainName;
  }


  /**
   * Sets the value of the 'trainName' field.
   * @param value the value to set.
   */
  public void setTrainName(java.lang.CharSequence value) {
    this.trainName = value;
  }

  /**
   * Gets the value of the 'seatNumber' field.
   * @return The value of the 'seatNumber' field.
   */
  public java.lang.CharSequence getSeatNumber() {
    return seatNumber;
  }


  /**
   * Sets the value of the 'seatNumber' field.
   * @param value the value to set.
   */
  public void setSeatNumber(java.lang.CharSequence value) {
    this.seatNumber = value;
  }

  /**
   * Creates a new TicketBookedEvent RecordBuilder.
   * @return A new TicketBookedEvent RecordBuilder
   */
  public static com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder newBuilder() {
    return new com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder();
  }

  /**
   * Creates a new TicketBookedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TicketBookedEvent RecordBuilder
   */
  public static com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder newBuilder(com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder other) {
    if (other == null) {
      return new com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder();
    } else {
      return new com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder(other);
    }
  }

  /**
   * Creates a new TicketBookedEvent RecordBuilder by copying an existing TicketBookedEvent instance.
   * @param other The existing instance to copy.
   * @return A new TicketBookedEvent RecordBuilder
   */
  public static com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder newBuilder(com.hy.ticketkatun.reservation.event.TicketBookedEvent other) {
    if (other == null) {
      return new com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder();
    } else {
      return new com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for TicketBookedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TicketBookedEvent>
    implements org.apache.avro.data.RecordBuilder<TicketBookedEvent> {

    private java.lang.CharSequence trainName;
    private java.lang.CharSequence seatNumber;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.trainName)) {
        this.trainName = data().deepCopy(fields()[0].schema(), other.trainName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.seatNumber)) {
        this.seatNumber = data().deepCopy(fields()[1].schema(), other.seatNumber);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing TicketBookedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.hy.ticketkatun.reservation.event.TicketBookedEvent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.trainName)) {
        this.trainName = data().deepCopy(fields()[0].schema(), other.trainName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.seatNumber)) {
        this.seatNumber = data().deepCopy(fields()[1].schema(), other.seatNumber);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'trainName' field.
      * @return The value.
      */
    public java.lang.CharSequence getTrainName() {
      return trainName;
    }


    /**
      * Sets the value of the 'trainName' field.
      * @param value The value of 'trainName'.
      * @return This builder.
      */
    public com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder setTrainName(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.trainName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'trainName' field has been set.
      * @return True if the 'trainName' field has been set, false otherwise.
      */
    public boolean hasTrainName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'trainName' field.
      * @return This builder.
      */
    public com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder clearTrainName() {
      trainName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'seatNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getSeatNumber() {
      return seatNumber;
    }


    /**
      * Sets the value of the 'seatNumber' field.
      * @param value The value of 'seatNumber'.
      * @return This builder.
      */
    public com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder setSeatNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.seatNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'seatNumber' field has been set.
      * @return True if the 'seatNumber' field has been set, false otherwise.
      */
    public boolean hasSeatNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'seatNumber' field.
      * @return This builder.
      */
    public com.hy.ticketkatun.reservation.event.TicketBookedEvent.Builder clearSeatNumber() {
      seatNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TicketBookedEvent build() {
      try {
        TicketBookedEvent record = new TicketBookedEvent();
        record.trainName = fieldSetFlags()[0] ? this.trainName : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.seatNumber = fieldSetFlags()[1] ? this.seatNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TicketBookedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<TicketBookedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TicketBookedEvent>
    READER$ = (org.apache.avro.io.DatumReader<TicketBookedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.trainName);

    out.writeString(this.seatNumber);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.trainName = in.readString(this.trainName instanceof Utf8 ? (Utf8)this.trainName : null);

      this.seatNumber = in.readString(this.seatNumber instanceof Utf8 ? (Utf8)this.seatNumber : null);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.trainName = in.readString(this.trainName instanceof Utf8 ? (Utf8)this.trainName : null);
          break;

        case 1:
          this.seatNumber = in.readString(this.seatNumber instanceof Utf8 ? (Utf8)this.seatNumber : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










